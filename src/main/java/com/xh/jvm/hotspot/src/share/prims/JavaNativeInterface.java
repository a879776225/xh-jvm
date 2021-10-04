package com.xh.jvm.hotspot.src.share.prims;


import com.xh.jvm.hotspot.src.share.intepreter.BytecodeInterpreter;
import com.xh.jvm.hotspot.src.share.oops.CodeAttributeInfo;
import com.xh.jvm.hotspot.src.share.oops.InstanceKlass;
import com.xh.jvm.hotspot.src.share.oops.MethodInfo;
import com.xh.jvm.hotspot.src.share.runtime.JavaThread;
import com.xh.jvm.hotspot.src.share.runtime.JavaVFrame;
import com.xh.jvm.hotspot.src.share.runtime.Threads;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: xh
 * @Date: 2021/6 07:34
 */
public class JavaNativeInterface {

    private final static Logger logger = LoggerFactory.getLogger(JavaNativeInterface.class);

    public static InstanceKlass findClass(String name) {

        return null;
    }

    public static MethodInfo getMethodID(InstanceKlass klass, String name, String descriptorName) {
        MethodInfo[] methods = klass.getMethods();
        for (MethodInfo method:methods) {
            String tmpName = (String) klass.getConstantPool().getDataMap().get(method.getNameIndex());
            String tmpDescriptor = (String) klass.getConstantPool().getDataMap().get(method.getDescriptorIndex());

            if (tmpName.equals(name) && tmpDescriptor.equals(descriptorName)) {
                logger.info("找到了方法: " + name + "#" + descriptorName);

                return method;
            }
        }

        logger.error("没有找到方法: " + name + "#" + descriptorName);

        return null;
    }

    public static void callStaticMethod(MethodInfo method) {
        JavaThread thread = Threads.currentThread();

        if (!method.getAccessFlags().isStatic()) {
            throw new Error("只能调用静态方法");
        }

        CodeAttributeInfo codeAttributeInfo = method.getAttributes()[0];

        // 创建栈帧
        JavaVFrame frame = new JavaVFrame(codeAttributeInfo.getMaxLocals(), method);

        thread.getStack().push(frame);

        logger.info("第 " + thread.getStack().size() + " 个栈帧");

        // 执行任务交给字节码解释器
        BytecodeInterpreter.run(thread, method);
    }

}
