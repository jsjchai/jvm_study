package com.github.jsjchai.gc;

/**
 *  引用计数算法的缺陷:对象之间相互循环引用
 *   VM args: -XX:+PrintGCDetails
 * @author jsjchai.
 */
public class ReferenceCountingGC {

    public Object instance = null;

    private static final int ONE_MB = 1024 * 1024;

    /**
     *  方便查看GC日志中是否被回收
     */
    private byte[] bigsize = new byte[2 * ONE_MB];

    public static void testGC(){

        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        /*相互引用*/
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        //假设发生，objA和objB是否能被回收
        System.gc();

    }

    public static void main(String[] args) {
        testGC();
    }

}
