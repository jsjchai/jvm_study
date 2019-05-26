package com.github.jsjchai.gc;

/**
 * 模拟新生代GC
 *
 * @author jsjchai.
 */
public class MinorGC {

    private static final int ONEMB = 1024 * 1024;

    /**
     * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation() {

        byte[] allocation1 = new byte[2 * ONEMB];
        byte[] allocation2 = new byte[2 * ONEMB];
        byte[] allocation3 = new byte[2 * ONEMB];
        //发生一次Minor GC
        byte[] allocation4 = new byte[4 * ONEMB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
