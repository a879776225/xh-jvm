package com.xh.jvm.hotspot.src.share.oops;

import lombok.Data;

/**
 * Created By xh
 * -
 * 2021/4/4
 */
@Data
public class InterfaceInfo {

    private int constantPoolIndex;

    private String interfaceName;

    public InterfaceInfo(int index, String name) {
        this.constantPoolIndex = index;
        this.interfaceName = name;
    }
}