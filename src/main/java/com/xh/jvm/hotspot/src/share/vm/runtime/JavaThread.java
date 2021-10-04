package com.xh.jvm.hotspot.src.share.vm.runtime;

import lombok.Data;

import java.util.Stack;

/**
 * @Author: xh
 * @Date: 2021/6 14:18
 */
@Data
public class JavaThread extends Thread {

    private Stack<VFrame> stack = new Stack<>();

}
