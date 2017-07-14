package com.ggr.myspring.CGLIBProxy;

import com.ggr.myspring.JDKProxy.Advice;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class MyMethodInterceptor implements MethodInterceptor
{

    private Advice advice = null;

    MyMethodInterceptor(){}

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public Advice getAdvice() {
        return advice;
    }
    public MyMethodInterceptor(Advice advice){
        this.advice =advice;
    }

    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if(this.advice==null){
            throw  new IllegalArgumentException("please first init the Advice");
        }
        this.advice.before();
        Object obj = methodProxy.invokeSuper(o,args);
        this.advice.after();
        return obj;
    }
}
