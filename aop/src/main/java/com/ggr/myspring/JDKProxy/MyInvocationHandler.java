package com.ggr.myspring.JDKProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Myservice myservice = null;

    private Advice advice = null;

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    public void setMyservice(Myservice myservice) {
        this.myservice = myservice;
    }

    public Myservice getMyservice() {
        return myservice;
    }

    public Advice getAdvice() {
        return advice;
    }

    public MyInvocationHandler(){}

    public MyInvocationHandler(Advice advice,Myservice myservice){
        this.advice = advice;
        this.myservice=myservice;
    }


    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(this.advice==null||this.myservice==null){
            throw new IllegalArgumentException("please first init the Advice or target");
        }
        this.advice.before();
        Object result = method.invoke(this.myservice,args);
        this.advice.after();
        return result;
    }
}
