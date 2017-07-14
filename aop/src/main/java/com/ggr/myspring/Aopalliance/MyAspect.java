package com.ggr.myspring.Aopalliance;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 定义一个环绕的通知,AopAlliance的环绕通知必须手动执行目标方法
 */
public class MyAspect implements MethodInterceptor {

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("这是一个环绕通知的前置位");

        Object result = methodInvocation.proceed();

        System.out.println("这是一个环绕通知的后置位");

        return result;
    }
}
