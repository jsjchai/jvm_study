package com.github.jsjchai.sof;

/**
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
