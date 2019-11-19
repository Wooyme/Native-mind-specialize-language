// Generated from /home/wooyme/Projects/simplelanguage/language/src/main/java/com/oracle/truffle/sl/parser/SimpleLanguage.g4 by ANTLR 4.7.2
package com.oracle.truffle.sl.parser;

// DO NOT MODIFY - generated from SimpleLanguage.g4 using "mx create-sl-parser"

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, WS=37, COMMENT=38, LINE_COMMENT=39, 
		LOGICAL_LITERAL=40, IDENTIFIER=41, STRING_LITERAL=42, NUMERIC_LITERAL=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "WS", "COMMENT", "LINE_COMMENT", "LETTER", 
			"NON_ZERO_DIGIT", "DIGIT", "HEX_DIGIT", "OCT_DIGIT", "BINARY_DIGIT", 
			"TAB", "STRING_CHAR", "LOGICAL_LITERAL", "IDENTIFIER", "STRING_LITERAL", 
			"NUMERIC_LITERAL"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'import'", "';'", "'load'", "'fn'", "'('", "','", "')'", 
			"'{'", "':'", "'}'", "'break'", "'continue'", "'debugger'", "'while'", 
			"'if'", "'else'", "'return'", "'||'", "'&&'", "'<'", "'<='", "'>'", "'>='", 
			"'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'!'", "'null'", "'['", "']'", 
			"'.'", "'..'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "WS", "COMMENT", "LINE_COMMENT", "LOGICAL_LITERAL", "IDENTIFIER", 
			"STRING_LITERAL", "NUMERIC_LITERAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SimpleLanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLanguage.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u015e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"+
		"\3\37\3\37\3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\6&\u00e5"+
		"\n&\r&\16&\u00e6\3&\3&\3\'\3\'\3\'\3\'\7\'\u00ef\n\'\f\'\16\'\u00f2\13"+
		"\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\7(\u00fd\n(\f(\16(\u0100\13(\3(\3("+
		"\3)\5)\u0105\n)\3*\3*\3+\3+\3,\5,\u010c\n,\3-\3-\3.\3.\3/\3/\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0121\n\60"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u012c\n\61\3\62\3\62"+
		"\3\62\7\62\u0131\n\62\f\62\16\62\u0134\13\62\3\63\3\63\7\63\u0138\n\63"+
		"\f\63\16\63\u013b\13\63\3\63\3\63\3\64\3\64\3\64\7\64\u0142\n\64\f\64"+
		"\16\64\u0145\13\64\3\64\3\64\3\64\7\64\u014a\n\64\f\64\16\64\u014d\13"+
		"\64\3\64\3\64\7\64\u0151\n\64\f\64\16\64\u0154\13\64\3\64\3\64\7\64\u0158"+
		"\n\64\f\64\16\64\u015b\13\64\5\64\u015d\n\64\3\u00f0\2\65\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q\2S\2U\2W\2Y\2[\2]\2_\2a*c+e,g-\3\2\n\5\2\13\f\16\17\"\"\4"+
		"\2\f\f\17\17\6\2&&C\\aac|\3\2\63;\3\2\62;\5\2\62;CHch\3\2\629\6\2\f\f"+
		"\17\17$$^^\2\u0169\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2a\3\2"+
		"\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7r\3\2\2\2"+
		"\tt\3\2\2\2\13y\3\2\2\2\r|\3\2\2\2\17~\3\2\2\2\21\u0080\3\2\2\2\23\u0082"+
		"\3\2\2\2\25\u0084\3\2\2\2\27\u0086\3\2\2\2\31\u0088\3\2\2\2\33\u008e\3"+
		"\2\2\2\35\u0097\3\2\2\2\37\u00a0\3\2\2\2!\u00a6\3\2\2\2#\u00a9\3\2\2\2"+
		"%\u00ae\3\2\2\2\'\u00b5\3\2\2\2)\u00b8\3\2\2\2+\u00bb\3\2\2\2-\u00bd\3"+
		"\2\2\2/\u00c0\3\2\2\2\61\u00c2\3\2\2\2\63\u00c5\3\2\2\2\65\u00c8\3\2\2"+
		"\2\67\u00cb\3\2\2\29\u00cd\3\2\2\2;\u00cf\3\2\2\2=\u00d1\3\2\2\2?\u00d3"+
		"\3\2\2\2A\u00d5\3\2\2\2C\u00da\3\2\2\2E\u00dc\3\2\2\2G\u00de\3\2\2\2I"+
		"\u00e0\3\2\2\2K\u00e4\3\2\2\2M\u00ea\3\2\2\2O\u00f8\3\2\2\2Q\u0104\3\2"+
		"\2\2S\u0106\3\2\2\2U\u0108\3\2\2\2W\u010b\3\2\2\2Y\u010d\3\2\2\2[\u010f"+
		"\3\2\2\2]\u0111\3\2\2\2_\u0120\3\2\2\2a\u012b\3\2\2\2c\u012d\3\2\2\2e"+
		"\u0135\3\2\2\2g\u015c\3\2\2\2ij\7?\2\2j\4\3\2\2\2kl\7k\2\2lm\7o\2\2mn"+
		"\7r\2\2no\7q\2\2op\7t\2\2pq\7v\2\2q\6\3\2\2\2rs\7=\2\2s\b\3\2\2\2tu\7"+
		"n\2\2uv\7q\2\2vw\7c\2\2wx\7f\2\2x\n\3\2\2\2yz\7h\2\2z{\7p\2\2{\f\3\2\2"+
		"\2|}\7*\2\2}\16\3\2\2\2~\177\7.\2\2\177\20\3\2\2\2\u0080\u0081\7+\2\2"+
		"\u0081\22\3\2\2\2\u0082\u0083\7}\2\2\u0083\24\3\2\2\2\u0084\u0085\7<\2"+
		"\2\u0085\26\3\2\2\2\u0086\u0087\7\177\2\2\u0087\30\3\2\2\2\u0088\u0089"+
		"\7d\2\2\u0089\u008a\7t\2\2\u008a\u008b\7g\2\2\u008b\u008c\7c\2\2\u008c"+
		"\u008d\7m\2\2\u008d\32\3\2\2\2\u008e\u008f\7e\2\2\u008f\u0090\7q\2\2\u0090"+
		"\u0091\7p\2\2\u0091\u0092\7v\2\2\u0092\u0093\7k\2\2\u0093\u0094\7p\2\2"+
		"\u0094\u0095\7w\2\2\u0095\u0096\7g\2\2\u0096\34\3\2\2\2\u0097\u0098\7"+
		"f\2\2\u0098\u0099\7g\2\2\u0099\u009a\7d\2\2\u009a\u009b\7w\2\2\u009b\u009c"+
		"\7i\2\2\u009c\u009d\7i\2\2\u009d\u009e\7g\2\2\u009e\u009f\7t\2\2\u009f"+
		"\36\3\2\2\2\u00a0\u00a1\7y\2\2\u00a1\u00a2\7j\2\2\u00a2\u00a3\7k\2\2\u00a3"+
		"\u00a4\7n\2\2\u00a4\u00a5\7g\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7k\2\2\u00a7"+
		"\u00a8\7h\2\2\u00a8\"\3\2\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7n\2\2\u00ab"+
		"\u00ac\7u\2\2\u00ac\u00ad\7g\2\2\u00ad$\3\2\2\2\u00ae\u00af\7t\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7w\2\2\u00b2\u00b3\7t\2\2"+
		"\u00b3\u00b4\7p\2\2\u00b4&\3\2\2\2\u00b5\u00b6\7~\2\2\u00b6\u00b7\7~\2"+
		"\2\u00b7(\3\2\2\2\u00b8\u00b9\7(\2\2\u00b9\u00ba\7(\2\2\u00ba*\3\2\2\2"+
		"\u00bb\u00bc\7>\2\2\u00bc,\3\2\2\2\u00bd\u00be\7>\2\2\u00be\u00bf\7?\2"+
		"\2\u00bf.\3\2\2\2\u00c0\u00c1\7@\2\2\u00c1\60\3\2\2\2\u00c2\u00c3\7@\2"+
		"\2\u00c3\u00c4\7?\2\2\u00c4\62\3\2\2\2\u00c5\u00c6\7?\2\2\u00c6\u00c7"+
		"\7?\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7#\2\2\u00c9\u00ca\7?\2\2\u00ca\66"+
		"\3\2\2\2\u00cb\u00cc\7-\2\2\u00cc8\3\2\2\2\u00cd\u00ce\7/\2\2\u00ce:\3"+
		"\2\2\2\u00cf\u00d0\7,\2\2\u00d0<\3\2\2\2\u00d1\u00d2\7\61\2\2\u00d2>\3"+
		"\2\2\2\u00d3\u00d4\7#\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7"+
		"\7w\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7n\2\2\u00d9B\3\2\2\2\u00da\u00db"+
		"\7]\2\2\u00dbD\3\2\2\2\u00dc\u00dd\7_\2\2\u00ddF\3\2\2\2\u00de\u00df\7"+
		"\60\2\2\u00dfH\3\2\2\2\u00e0\u00e1\7\60\2\2\u00e1\u00e2\7\60\2\2\u00e2"+
		"J\3\2\2\2\u00e3\u00e5\t\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2"+
		"\u00e6\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9"+
		"\b&\2\2\u00e9L\3\2\2\2\u00ea\u00eb\7\61\2\2\u00eb\u00ec\7,\2\2\u00ec\u00f0"+
		"\3\2\2\2\u00ed\u00ef\13\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f2\3\2\2\2"+
		"\u00f0\u00f1\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00f0"+
		"\3\2\2\2\u00f3\u00f4\7,\2\2\u00f4\u00f5\7\61\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\b\'\2\2\u00f7N\3\2\2\2\u00f8\u00f9\7\61\2\2\u00f9\u00fa\7\61\2"+
		"\2\u00fa\u00fe\3\2\2\2\u00fb\u00fd\n\3\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100"+
		"\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0101\u0102\b(\2\2\u0102P\3\2\2\2\u0103\u0105\t\4\2\2\u0104"+
		"\u0103\3\2\2\2\u0105R\3\2\2\2\u0106\u0107\t\5\2\2\u0107T\3\2\2\2\u0108"+
		"\u0109\t\6\2\2\u0109V\3\2\2\2\u010a\u010c\t\7\2\2\u010b\u010a\3\2\2\2"+
		"\u010cX\3\2\2\2\u010d\u010e\t\b\2\2\u010eZ\3\2\2\2\u010f\u0110\4\62\63"+
		"\2\u0110\\\3\2\2\2\u0111\u0112\7\13\2\2\u0112^\3\2\2\2\u0113\u0114\7^"+
		"\2\2\u0114\u0121\7^\2\2\u0115\u0116\7^\2\2\u0116\u0121\7$\2\2\u0117\u0118"+
		"\7^\2\2\u0118\u0121\7p\2\2\u0119\u011a\7^\2\2\u011a\u0121\7v\2\2\u011b"+
		"\u011c\7^\2\2\u011c\u0121\7t\2\2\u011d\u011e\7^\2\2\u011e\u0121\7z\2\2"+
		"\u011f\u0121\n\t\2\2\u0120\u0113\3\2\2\2\u0120\u0115\3\2\2\2\u0120\u0117"+
		"\3\2\2\2\u0120\u0119\3\2\2\2\u0120\u011b\3\2\2\2\u0120\u011d\3\2\2\2\u0120"+
		"\u011f\3\2\2\2\u0121`\3\2\2\2\u0122\u0123\7v\2\2\u0123\u0124\7t\2\2\u0124"+
		"\u0125\7w\2\2\u0125\u012c\7g\2\2\u0126\u0127\7h\2\2\u0127\u0128\7c\2\2"+
		"\u0128\u0129\7n\2\2\u0129\u012a\7u\2\2\u012a\u012c\7g\2\2\u012b\u0122"+
		"\3\2\2\2\u012b\u0126\3\2\2\2\u012cb\3\2\2\2\u012d\u0132\5Q)\2\u012e\u0131"+
		"\5Q)\2\u012f\u0131\5U+\2\u0130\u012e\3\2\2\2\u0130\u012f\3\2\2\2\u0131"+
		"\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2\2\2\u0133d\3\2\2\2"+
		"\u0134\u0132\3\2\2\2\u0135\u0139\7$\2\2\u0136\u0138\5_\60\2\u0137\u0136"+
		"\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a"+
		"\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c\u013d\7$\2\2\u013df\3\2\2\2\u013e"+
		"\u015d\7\62\2\2\u013f\u0143\5S*\2\u0140\u0142\5U+\2\u0141\u0140\3\2\2"+
		"\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u015d"+
		"\3\2\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7\62\2\2\u0147\u014b\7\60\2\2"+
		"\u0148\u014a\5U+\2\u0149\u0148\3\2\2\2\u014a\u014d\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u015d\3\2\2\2\u014d\u014b\3\2\2\2\u014e"+
		"\u0152\5S*\2\u014f\u0151\5U+\2\u0150\u014f\3\2\2\2\u0151\u0154\3\2\2\2"+
		"\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154\u0152"+
		"\3\2\2\2\u0155\u0159\7\60\2\2\u0156\u0158\5U+\2\u0157\u0156\3\2\2\2\u0158"+
		"\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2\2\2\u015a\u015d\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015c\u013e\3\2\2\2\u015c\u013f\3\2\2\2\u015c"+
		"\u0146\3\2\2\2\u015c\u014e\3\2\2\2\u015dh\3\2\2\2\22\2\u00e6\u00f0\u00fe"+
		"\u0104\u010b\u0120\u012b\u0130\u0132\u0139\u0143\u014b\u0152\u0159\u015c"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}