package com.xh.jvm.hotspot.src.share.oops;

import lombok.Data;

/**
 * @Author: xh
 * @Date: 2021/6/7 10:23
 */
@Data
public class LineNumberTable extends AttributeInfo {

    private int tableLength;
    private Item[] table;

    public void initTable() {
        table = new Item[tableLength];
    }

    @Data
    public class Item {
        private int startPc;
        private int lineNumber;
    }
}
