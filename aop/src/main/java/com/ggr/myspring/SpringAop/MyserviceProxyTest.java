package com.ggr.myspring.SpringAop;

import com.ggr.myspring.Aopalliance.Myservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class MyserviceProxyTest {

    @Test
    public void testAopAplliance(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext-springaop.xml");
        Myservice myservice = (Myservice) applicationContext.getBean("myservice");
        myservice.add();
        System.out.println(myservice.update());
    }
}