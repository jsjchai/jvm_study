package com.github.jsjchai.oom;

/**
 * VM args: -Xss2M
 * @author jsjchai.
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while(true){

        }
    }

    public static void main(String[] args) {

        JavaVMStackOOM oom = new JavaVMStackOOM();
        while (true){
            new Thread(() -> oom.dontStop()).start();
        }
    }
}
