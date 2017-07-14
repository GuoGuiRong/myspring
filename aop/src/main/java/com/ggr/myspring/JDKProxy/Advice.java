package com.ggr.myspring.JDKProxy;

/**
 * 定义通知
 */
public class Advice{

    public void before(){
        System.out.println("开启事务");
    }

    public void after(){
        System.out.println("关闭事务");
    }
}
