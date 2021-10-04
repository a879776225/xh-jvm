package com.xh.jvm.hotspot.src.share.runtime;

import com.xh.jvm.hotspot.src.share.memory.AllStatic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xh
 * @Date: 2021/6 14:12
 */
@Data
public class Threads extends AllStatic {

    /**
     * 所有的Java基本线程全部存储在这个list中
     */
    private static List<Thread> threadList;

    private static Thread currentThread;

    static {
        threadList = new ArrayList<>();
    }

    public static List<Thread> getThreadList() {
        return threadList;
    }

    public static JavaThread currentThread() {
        return (JavaThread) currentThread;
    }

    public static void setCurrentThread(Thread thread) {
        currentThread = thread;
    }
}
