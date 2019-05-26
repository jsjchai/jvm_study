package com.github.jsjchai.gc;

/**
 * 空间分配担保
 * 在发生Minor GC之前，虚拟机会先检查老年代最大可用的连续空间是否大于新生代所有对象空间
 * 如果这个条件成立，则Minor GC可以确保是安全的
 * 如果不成立，则虚拟机会查看HandlePromotionFailure设置值是否允许担保失败
 * 通过判断HandlePromotionFailure的值，Minor GC 还是 Full Gc
 * JDK 6 Update 24之后的规则变为只要老年代的连续空间大于新生代对象总大小或者历次晋升的平均大小就会进行Minor GC，否则将进行Full GC
 *
 * @author jsjchai.
 */
public class HandlePromotion {

    private static final int ONEMB = 1024 * 1024;

    /**
     * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     *  -XX:-HandlePromotionFailure
     */
    public static void testHandlePromotion() {

        byte[] allocation1 = new byte[2 * ONEMB];
        byte[] allocation2 = new byte[2 * ONEMB];
        byte[] allocation3 = new byte[2 * ONEMB];

        allocation1 = null;

        byte[] allocation4 = new byte[2 * ONEMB];
        byte[] allocation5 = new byte[2 * ONEMB];
        byte[] allocation6 = new byte[2 * ONEMB];

        allocation4 = null;
        allocation5 = null;
        allocation6 = null;

        byte[] allocation7 = new byte[2 * ONEMB];

    }

    public static void main(String[] args) {
        testHandlePromotion();
    }

}
