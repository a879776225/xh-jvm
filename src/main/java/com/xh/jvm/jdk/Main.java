package com.xh.jvm.jdk;


import com.xh.jvm.hotspot.src.share.vm.oops.InstanceKlass;
import com.xh.jvm.hotspot.src.share.vm.oops.MethodInfo;
import com.xh.jvm.hotspot.src.share.vm.prims.JavaNativeInterface;
import com.xh.jvm.hotspot.src.share.vm.runtime.JavaThread;
import com.xh.jvm.hotspot.src.share.vm.runtime.Threads;
import com.xh.jvm.hotspot.src.share.vm.classfile.BootClassLoader;

public class Main {

    public static void main(String[] args) {
        startJVM();
    }

    public static void startJVM() {
        // 通过AppClassLoader加载main函数所在的类
        InstanceKlass mainKlass = BootClassLoader.loadMainKlass("com.xh.jvm.example.HelloWorld");

        // 找到main方法
        MethodInfo mainMethod = JavaNativeInterface.getMethodID(mainKlass,"main", "([Ljava/lang/String;)V");

        // 创建线程
        JavaThread thread = new JavaThread();

        Threads.getThreadList().add(thread);
        Threads.setCurrentThread(thread);

        // 执行main方法
        JavaNativeInterface.callStaticMethod(mainMethod);
    }
}
