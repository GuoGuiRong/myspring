package com.ggr.myspring.Aopalliance;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class MyserviceProxyTest {

    @Test
    public void testAopAplliance(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-aopaplliance.xml");
        Myservice myservice = (Myservice) applicationContext.getBean("proxyService");
        myservice.add();
        System.out.println(myservice.update());
    }
}