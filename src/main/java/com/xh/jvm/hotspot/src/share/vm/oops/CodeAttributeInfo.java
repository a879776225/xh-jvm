package com.xh.jvm.hotspot.src.share.vm.oops;


import com.xh.jvm.hotspot.src.share.vm.intepreter.BytecodeStream;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xh
 * @Date: 2021/6/2021/6 17:55
 */
@Data
public class CodeAttributeInfo {

    private int attrNameIndex;
    private int attrLength;

    private int maxStack;
    private int maxLocals;

    private int codeLength;
    private BytecodeStream code;

    private int exceptionTableLength;

    // 如局部变量表、操作数栈
    private int attributesCount;

    private Map<String, AttributeInfo> attributes = new HashMap<>();

}
