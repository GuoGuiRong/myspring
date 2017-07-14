package com.ggr.myspring.CGLIBProxy;

import com.ggr.myspring.JDKProxy.Advice;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class CGLIBProxy {
    public static void main(String[] args) {
        final Myservice myservice = new Myservice();
        final Advice advice = new Advice();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(myservice.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

                advice.before();
                Object result = method.invoke(myservice,objects);
                advice.after();
                return result;
            }
        });
        Myservice myservice1 = (Myservice) enhancer.create();
        myservice1.singSongs();
    }

}
