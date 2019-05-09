package com.github.jsjchai.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *  java堆内存溢出
 * VM args: -Xms30m -Xmx30m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author jsjchai.
 */
public class HeapOOM {

    /* Java heap space */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>(1000);
        while (true) {
            list.add(new OOMObject());
        }
    }

    private static class OOMObject {

    }
}
