package com.github.jsjchai.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms30m -Xmx30m -XX:+HeapDumpOnOutOfMemoryError
 * jdk version: 1.8
 *
 * @author jsjchai.
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

    private static class OOMObject {

    }
}
