package com.xh.jvm.hotspot.src.share.intepreter;


import com.xh.jvm.hotspot.src.share.oops.CodeAttributeInfo;
import com.xh.jvm.hotspot.src.share.oops.MethodInfo;

/**
 * @Author: xh
 * @Date: 2021/6 14:55
 */
public class BytecodeStream extends BaseBytecodeStream {

    public BytecodeStream(MethodInfo belongMethod, CodeAttributeInfo belongCode) {
        this.belongMethod = belongMethod;
        this.belongCode = belongCode;
        this.length = belongCode.getCodeLength();
        this.index = 0;
        this.codes = new byte[this.length];
    }

}
