package com.github.jsjchai.gc;

/**
 * 长期存活的对象将进入老年代
 *
 * @author jsjchai.
 */
public class TenuringThreshold {

    private static final int ONEMB = 1024 * 1024;

    /**
     *  长期存活的对象将进入老年代
     * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold() {

        byte[] allocation1 = new byte[ONEMB / 4];
        byte[] allocation2 = new byte[ONEMB * 4];
        byte[] allocation3 = new byte[ONEMB * 5];
        allocation3 = null;
        allocation3 = new byte[ONEMB * 5];

    }

    /**
     *  动态对象年龄判断
     * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution
     */
    public static void testTenuringThreshold2() {

        byte[] allocation1 = new byte[ONEMB / 4];
        byte[] allocation2 = new byte[ONEMB / 4];
        byte[] allocation3 = new byte[ONEMB * 4];
        byte[] allocation4 = new byte[ONEMB * 5];
        allocation4 = null;
        allocation4 = new byte[ONEMB * 5];

    }

    public static void main(String[] args) {
        testTenuringThreshold2();
    }
}
