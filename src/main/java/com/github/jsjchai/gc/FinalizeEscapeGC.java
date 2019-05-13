package com.github.jsjchai.gc;

import java.util.concurrent.TimeUnit;

/**
 *  虚拟机对已经执行过finalize方法的对象，不会再执行垃圾回收
 *  1.对象在GC后避免被回收
 *  2. 只能避免被回次一次，下次还是会被回收（一个对象的finalize()方法最多被系统自动调用一次）
 * @author jsjchai.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVA_HOOK = null;

    public void  isAlive(){
        System.out.println("SAVA_HOOK alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize...");
        FinalizeEscapeGC.SAVA_HOOK = this;
    }

    private static void gc()  throws Throwable{

        //垃圾回收一次
        SAVA_HOOK = null;
        System.gc();

        TimeUnit.MILLISECONDS.sleep(500);

        if (SAVA_HOOK != null) {
            SAVA_HOOK.isAlive();
        } else {
            System.out.println("SAVA_HOOK dead");
        }
    }

    public static void main(String[] args) throws Throwable {

        SAVA_HOOK = new FinalizeEscapeGC();

        //逃离垃圾回收
        gc();

        //还是被垃圾回收
        gc();


    }
}
