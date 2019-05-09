package com.github.jsjchai.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 *  借助CGLib使方法区溢出
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
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
