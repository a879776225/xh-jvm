package com.xh.jvm.hotspot.src.share.vm.oops;

import lombok.Data;

/**
 * @Author: xh
 * @Date: 2021/6/2021/6 12021/6:52021/6
 */
@Data
public class FieldInfo {

    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;
    private int attributesCount;

    private CodeAttributeInfo[] attributes;



}
