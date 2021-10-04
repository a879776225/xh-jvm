package com.xh.jvm.hotspot.src.share.vm.utilities;

import lombok.Data;

/**
 * Created By xh
 * -
 * 2021/6/31
 */
@Data
public class AccessFlags {

    private int flag;

    public AccessFlags(int flag) {
        this.flag = flag;
    }

    public boolean isStatic() {
        return (flag & BasicType.JVM_ACC_STATIC) != 0;
    }
}
