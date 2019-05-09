package com.github.jsjchai.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 *  借助CGLib使方法区溢出
 *  在jdk1.7中，永久代是方法区的实现，永久带不在堆中
 *  jdk1.7 VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *  jdk1.8之后，永久代被移除，元空间用来实现方法区。元空间被放到了java堆中，和堆共享内存大小。逻辑上不互联，物理上互联
 *  jdk1.8 VM args: -Xms30m -Xmx30m
 *
 * @author jsjchai.
 */
public class JavaMethodAreaOOM {

    public static void main(final String[] args) {
        while (true){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,args));
            enhancer.create();
        }
    }

     static class OOMObject{

    }
}
