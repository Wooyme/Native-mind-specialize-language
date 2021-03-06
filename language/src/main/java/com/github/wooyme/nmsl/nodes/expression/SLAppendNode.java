package com.github.wooyme.nmsl.nodes.expression;

import com.github.wooyme.nmsl.nodes.SLExpressionNode;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.nodes.NodeInfo;

import java.util.List;

@NodeInfo(shortName = "append")
@NodeChild("receiverNode")
@NodeChild("valueNode")
public abstract class SLAppendNode extends SLExpressionNode {
    @Specialization
    public long append(List receiver, Object value){
        receiver.add(value);
        return 0;
    }
}
