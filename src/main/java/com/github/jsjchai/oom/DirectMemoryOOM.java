package com.github.jsjchai.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 *  使用unsafe分配本机内存
 * @author jsjchai.
 */
public class DirectMemoryOOM {

    /**
     *  VM args:  -Xmx20M -XX:MaxDirectMemorySize=10M
     * 1MB
     */
    private  static final int ONE_MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true){
            unsafe.allocateMemory(ONE_MB);
        }
    }


}
