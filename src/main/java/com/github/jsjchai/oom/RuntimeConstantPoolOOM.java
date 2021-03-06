package com.github.jsjchai.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *  运行时常量池内存溢出
 *  jdk1.6会抛出异常，jdk1.7以上版本会一直运行下去
 *  VM args: -XX:PermSize=10M  -XX:MaxPermSize=10M
 * @author jsjchai.
 */
public class RuntimeConstantPoolOOM {

    /**
     * intern记录在常量池中首次出现的实例引用
     */
    private static  void internEquels(){


         /*首次出现 true*/
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        /*"java"非首次出现 false*/
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }

    private static  void oom(){
        List<String> list = new ArrayList<>(1000);

        int i=0;
        while (true){
            list.add(String.valueOf(i++).intern());
        }
    }


    public static void main(String[] args) {
        //internEquels();

        oom();
    }

}
