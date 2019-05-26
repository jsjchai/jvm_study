package com.github.jsjchai.gc;

/**
 * 大对象直接进入老年代
 *
 * @author jsjchai.
 */
public class PretenureSizeThreshold {

    private static final int ONEMB = 1024 * 1024;

    /**
     * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * -XX:PretenureSizeThreshold=3145728   3MB 未生效
     * -XX:PretenureSizeThreshold只对串行回收器和ParNew有效，对ParallGC无效。默认该值为0，即不指定最大的晋升大小，一切由运行情况决定
     */
    public static void testPretenureSizeThreshold() {

        //直接分配到老年代
        byte[] allocation = new byte[9 * ONEMB];
    }

    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
