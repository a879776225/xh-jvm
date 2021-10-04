package com.xh.jvm.hotspot.src.share.runtime;

import lombok.Data;

/**
 * Created By xh
 * QQ: 3039277701
 * 2021/6/29
 */
@Data
public class StackValue {

    private int type;

    /**
     * 数据
     */
    private int val;

    private Object object;

    public StackValue(int type, int val) {
        this.type = type;
        this.val = val;
    }

    public StackValue(int type, Object val) {
        this.type = type;
        this.object = val;
    }
}
