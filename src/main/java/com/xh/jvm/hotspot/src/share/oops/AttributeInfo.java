package com.xh.jvm.hotspot.src.share.oops;

import lombok.Data;

/**
 * @Author: xh
 * @Date: 2021/6/2021/6 17:55
 */
@Data
public class AttributeInfo {

    private int attrNameIndex;
    private int attrLength;

    // 用于存储klass的attribute
    private byte[] container;

    public void initContainer() {
        container = new byte[attrLength];
    }
}
