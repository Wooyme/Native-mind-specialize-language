/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * The Universal Permissive License (UPL), Version 1.0
 *
 * Subject to the condition set forth below, permission is hereby granted to any
 * person obtaining a copy of this software, associated documentation and/or
 * data (collectively the "Software"), free of charge and under any and all
 * copyright rights in the Software, and any and all patent rights owned or
 * freely licensable by each licensor hereunder covering either (i) the
 * unmodified Software as contributed to or provided by such licensor, or (ii)
 * the Larger Works (as defined below), to deal in both
 *
 * (a) the Software, and
 *
 * (b) any piece of software and/or hardware listed in the lrgrwrks.txt file if
 * one is included with the Software each a "Larger Work" to which the Software
 * is contributed by such licensors),
 *
 * without restriction, including without limitation the rights to copy, create
 * derivative works of, display, perform, and distribute the Software and make,
 * use, sell, offer for sale, import, export, have made, and have sold the
 * Software and the Larger Work(s), and to sublicense the foregoing rights on
 * either these or other terms.
 *
 * This license is subject to the following condition:
 *
 * The above copyright notice and either this complete permission notice or at a
 * minimum a reference to the UPL must be included in all copies or substantial
 * portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.github.wooyme.nmsl;

import com.github.wooyme.nmsl.builtins.*;
import com.github.wooyme.nmsl.builtins.io.SLReadlnBuiltin;
import com.github.wooyme.nmsl.nodes.SLEvalRootNode;
import com.github.wooyme.nmsl.nodes.SLTypes;
import com.github.wooyme.nmsl.nodes.controlflow.*;
import com.github.wooyme.nmsl.nodes.expression.*;
import com.github.wooyme.nmsl.nodes.local.SLLexicalScope;
import com.github.wooyme.nmsl.nodes.local.SLReadLocalVariableNode;
import com.github.wooyme.nmsl.nodes.local.SLWriteLocalVariableNode;
import com.github.wooyme.nmsl.parser.SLNodeFactory;
import com.github.wooyme.nmsl.parser.SimpleLanguageLexer;
import com.github.wooyme.nmsl.parser.SimpleLanguageParser;
import com.github.wooyme.nmsl.runtime.*;
import com.oracle.truffle.api.*;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.debug.DebuggerTags;
import com.oracle.truffle.api.dsl.NodeFactory;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnsupportedMessageException;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.object.DynamicObject;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * SL is a simple language to demonstrate and showcase features of Truffle. The implementation is as
 * simple and clean as possible in order to help understanding the ideas and concepts of Truffle.
 * The language has first class functions, and objects are key-value stores.
 * <p>
 * SL is dynamically typed, i.e., there are no type names specified by the programmer. SL is
 * strongly typed, i.e., there is no automatic conversion between types. If an operation is not
 * available for the types encountered at run time, a type error is reported and execution is
 * stopped. For example, {@code 4 - "2"} results in a type error because subtraction is only defined
 * for numbers.
 *
 * <p>
 * <b>Types:</b>
 * <ul>
 * <li>Number: arbitrary precision integer numbers. The implementation uses the Java primitive type
 * {@code long} to represent numbers that fit into the 64 bit range, and {@link SLBigNumber} for
 * numbers that exceed the range. Using a primitive type such as {@code long} is crucial for
 * performance.
 * <li>Boolean: implemented as the Java primitive type {@code boolean}.
 * <li>String: implemented as the Java standard type {@link String}.
 * <li>Function: implementation type {@link SLFunction}.
 * <li>Object: efficient implementation using the object model provided by Truffle. The
 * implementation type of objects is a subclass of {@link DynamicObject}.
 * <li>Null (with only one value {@code null}): implemented as the singleton
 * {@link SLNull#SINGLETON}.
 * </ul>
 * The class {@link SLTypes} lists these types for the Truffle DSL, i.e., for type-specialized
 * operations that are specified using Truffle DSL annotations.
 *
 * <p>
 * <b>Language concepts:</b>
 * <ul>
 * <li>Literals for {@link SLBigIntegerLiteralNode numbers} , {@link SLStringLiteralNode strings},
 * and {@link SLFunctionLiteralNode functions}.
 * <li>Basic arithmetic, logical, and comparison operations: {@link SLAddNode +}, {@link SLSubNode
 * -}, {@link SLMulNode *}, {@link SLDivNode /}, {@link SLLogicalAndNode logical and},
 * {@link SLLogicalOrNode logical or}, {@link SLEqualNode ==}, !=, {@link SLLessThanNode &lt;},
 * {@link SLLessOrEqualNode &le;}, &gt;, &ge;.
 * <li>Local variables: local variables must be defined (via a {@link SLWriteLocalVariableNode
 * write}) before they can be used (by a {@link SLReadLocalVariableNode read}). Local variables are
 * not visible outside of the block where they were first defined.
 * <li>Basic control flow statements: {@link SLBlockNode blocks}, {@link SLIfNode if},
 * {@link SLWhileNode while} with {@link SLBreakNode break} and {@link SLContinueNode continue},
 * {@link SLReturnNode return}.
 * </ul>
 *
 * <p>
 * <b>Syntax and parsing:</b><br>
 * The syntax is described as an attributed grammar. The {@link SimpleLanguageParser} and
 * {@link SimpleLanguageLexer} are automatically generated by ANTLR 4. The grammar contains semantic
 * actions that build the AST for a method. To keep these semantic actions short, they are mostly
 * calls to the {@link SLNodeFactory} that performs the actual node creation. All functions found in
 * the SL source are added to the {@link SLFunctionRegistry}, which is accessible from the
 * {@link SLContext}.
 *
 * <p>
 * <b>Builtin functions:</b><br>
 * Library functions that are available to every SL source without prior definition are called
 * builtin functions. They are added to the {@link SLFunctionRegistry} when the {@link SLContext} is
 * created. Some of the current builtin functions are
 * <ul>
 * <li>{@link SLReadlnBuiltin readln}: Read a String from the {@link SLContext#getInput() standard
 * input}.
 * <li>{@link SLPrintBuiltin println}: Write a value to the {@link SLContext#getOutput() standard
 * output}.
 * <li>{@link SLNanoTimeBuiltin nanoTime}: Returns the value of a high-resolution time, in
 * nanoseconds.
 * <li>{@link SLDefineFunctionBuiltin defineFunction}: Parses the functions provided as a String
 * argument and adds them to the function registry. Functions that are already defined are replaced
 * with the new version.
 * <li>{@link SLStackTraceBuiltin stckTrace}: Print all function activations with all local
 * variables.
 * </ul>
 */
@TruffleLanguage.Registration(id = SLLanguage.ID, name = "SL", defaultMimeType = SLLanguage.MIME_TYPE, characterMimeTypes = SLLanguage.MIME_TYPE, contextPolicy = ContextPolicy.SHARED, fileTypeDetectors = SLFileDetector.class)
@ProvidedTags({StandardTags.CallTag.class, StandardTags.StatementTag.class, StandardTags.RootTag.class, StandardTags.RootBodyTag.class, StandardTags.ExpressionTag.class,
                DebuggerTags.AlwaysHalt.class})
public final class SLLanguage extends TruffleLanguage<SLContext> {
    public static volatile int counter;

    public static final String ID = "sl";
    public static final String MIME_TYPE = "application/x-sl";

    public SLLanguage() {
        counter++;
    }
    public static Object toLanguageObject(Object any,Class extra){
        if(any==null)
            return SLNull.SINGLETON;
        if(any instanceof Integer){
            return new SLBigNumber(new BigDecimal((Integer) any));
        }else if(any instanceof Long){
            return new SLBigNumber(new BigDecimal((Long) any));
        }else if(any instanceof Float){
            return new SLBigNumber(new BigDecimal((Float) any));
        }else if(any instanceof Double){
            return new SLBigNumber(new BigDecimal((Double) any));
        }else if(any instanceof BigInteger){
            return new SLBigNumber(new BigDecimal((BigInteger) any));
        }else if(any instanceof BigDecimal){
            return new SLBigNumber((BigDecimal) any);
        }else if(any instanceof Array){
            return new LinkedList<>(Arrays.asList((Object[]) any));
        }else if( SLProxy.getRaw(any)!=null || any instanceof String
                || any instanceof List || any instanceof Boolean
                || any instanceof TruffleObject
                || any instanceof SLObjectType || any instanceof SLReflection || any instanceof Reader || any instanceof Writer){
            return any;
        }else{
            return new SLReflection(any);
        }
    }

    @Override
    protected SLContext createContext(Env env) {
        return new SLContext(this, env, new ArrayList<>(EXTERNAL_BUILTINS));
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        Map<String, RootCallTarget> functions;
        /*
         * Parse the provided source. At this point, we do not have a SLContext yet. Registration of
         * the functions with the SLContext happens lazily in SLEvalRootNode.
         */
        if (request.getArgumentNames().isEmpty()) {
            functions = SimpleLanguageParser.parseSL(this, source);
        } else {
            Source requestedSource = request.getSource();
            StringBuilder sb = new StringBuilder();
            sb.append("fn main(");
            String sep = "";
            for (String argumentName : request.getArgumentNames()) {
                sb.append(sep);
                sb.append(argumentName);
                sep = ",";
            }
            sb.append(") { return ");
            sb.append(request.getSource().getCharacters());
            sb.append(";}");
            String language = requestedSource.getLanguage() == null ? ID : requestedSource.getLanguage();
            Source decoratedSource = Source.newBuilder(language, sb.toString(), request.getSource().getName()).build();
            functions = SimpleLanguageParser.parseSL(this, decoratedSource);
        }

        RootCallTarget main = functions.get("main");
        RootNode evalMain;
        if (main != null) {
            /*
             * We have a main function, so "evaluating" the parsed source means invoking that main
             * function. However, we need to lazily register functions into the SLContext first, so
             * we cannot use the original SLRootNode for the main function. Instead, we create a new
             * SLEvalRootNode that does everything we need.
             */
            evalMain = new SLEvalRootNode(this, main, functions);
        } else {
            /*
             * Even without a main function, "evaluating" the parsed source needs to register the
             * functions into the SLContext.
             */
            evalMain = new SLEvalRootNode(this, null, functions);
        }
        return Truffle.getRuntime().createCallTarget(evalMain);
    }

    /*
     * Still necessary for the old SL TCK to pass. We should remove with the old TCK. New language
     * should not override this.
     */
    @SuppressWarnings("deprecation")
    @Override
    protected Object findExportedSymbol(SLContext context, String globalName, boolean onlyExplicit) {
        return context.getFunctionRegistry().lookup(globalName, false);
    }

    @Override
    protected boolean isVisible(SLContext context, Object value) {
        return !InteropLibrary.getFactory().getUncached(value).isNull(value);
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        if (!(object instanceof TruffleObject)) {
            return false;
        } else if (object instanceof SLBigNumber || object instanceof SLFunction || object instanceof SLNull) {
            return true;
        } else if (SLContext.isSLObject(object)) {
            return true;
        } else {
            return false;
        }
    }



    @Override
    protected String toString(SLContext context, Object value) {
        return toString(value);
    }

    public static String toString(Object value) {
        try {
            if (value == null) {
                return "ANY";
            }
            InteropLibrary interop = InteropLibrary.getFactory().getUncached(value);
            if (interop.fitsInLong(value)) {
                return Long.toString(interop.asLong(value));
            } else if (interop.isBoolean(value)) {
                return Boolean.toString(interop.asBoolean(value));
            } else if (interop.isString(value)) {
                return interop.asString(value);
            } else if (interop.isNull(value)) {
                return "NULL";
            } else if (interop.isExecutable(value)) {
                if (value instanceof SLFunction) {
                    return ((SLFunction) value).getName();
                } else {
                    return "Function";
                }
            } else if (interop.hasMembers(value)) {
                return "Object";
            } else if (value instanceof SLBigNumber) {
                return value.toString();
            } else {
                return "Unsupported";
            }
        } catch (UnsupportedMessageException e) {
            CompilerDirectives.transferToInterpreter();
            throw new AssertionError();
        }
    }

    @Override
    protected Object findMetaObject(SLContext context, Object value) {
        return getMetaObject(value);
    }

    public static String getMetaObject(Object value) {
        if (value == null) {
            return "ANY";
        }
        InteropLibrary interop = InteropLibrary.getFactory().getUncached(value);
        if (interop.isNumber(value) || value instanceof SLBigNumber) {
            return "Number";
        } else if (interop.isBoolean(value)) {
            return "Boolean";
        } else if (interop.isString(value)) {
            return "String";
        } else if (interop.isNull(value)) {
            return "NULL";
        } else if (interop.isExecutable(value)) {
            return "Function";
        } else if (interop.hasMembers(value)) {
            return "Object";
        } else {
            return "Unsupported";
        }
    }

    @Override
    protected SourceSection findSourceLocation(SLContext context, Object value) {
        if (value instanceof SLFunction) {
            return ((SLFunction) value).getDeclaredLocation();
        }
        return null;
    }

    @Override
    public Iterable<Scope> findLocalScopes(SLContext context, Node node, Frame frame) {
        final SLLexicalScope scope = SLLexicalScope.createScope(node);
        return new Iterable<Scope>() {
            @Override
            public Iterator<Scope> iterator() {
                return new Iterator<Scope>() {
                    private SLLexicalScope previousScope;
                    private SLLexicalScope nextScope = scope;

                    @Override
                    public boolean hasNext() {
                        if (nextScope == null) {
                            nextScope = previousScope.findParent();
                        }
                        return nextScope != null;
                    }

                    @Override
                    public Scope next() {
                        if (!hasNext()) {
                            throw new NoSuchElementException();
                        }
                        Scope vscope = Scope.newBuilder(nextScope.getName(), nextScope.getVariables(frame)).node(nextScope.getNode()).arguments(nextScope.getArguments(frame)).build();
                        previousScope = nextScope;
                        nextScope = null;
                        return vscope;
                    }
                };
            }
        };
    }

    @Override
    protected Iterable<Scope> findTopScopes(SLContext context) {
        return context.getTopScopes();
    }

    public static SLContext getCurrentContext() {
        return getCurrentContext(SLLanguage.class);
    }

    private static final List<NodeFactory<? extends SLBuiltinNode>> EXTERNAL_BUILTINS = Collections.synchronizedList(new ArrayList<>());

    public static void installBuiltin(NodeFactory<? extends SLBuiltinNode> builtin) {
        EXTERNAL_BUILTINS.add(builtin);
    }

}
