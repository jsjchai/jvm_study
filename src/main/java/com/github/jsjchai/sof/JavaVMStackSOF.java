package com.github.jsjchai.sof;

/**
 *  栈帧太大还是虚拟机栈容量太小，内存无法分配，虚拟机抛出StackOverflowError异常
 * VM args: -Xss128k
 * @author jsjchai.
 */
public class JavaVMStackSOF {

    private int stackLen = 1;

    private void stackLeak() {
        stackLen++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stackLen: " + sof.stackLen);
            e.printStackTrace();
        }

    }
}
