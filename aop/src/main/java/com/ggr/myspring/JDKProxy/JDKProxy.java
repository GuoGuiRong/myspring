package com.ggr.myspring.JDKProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by GuiRunning on 2017/7/14.
 */
public class JDKProxy {

    public static void main(String[] args) {

        final Myservice myservice = new MyserviceImpl();
        final Advice advice =new Advice();

        /**开始使用jdk动态代理
         * ClassLoader loader 提供一个类加载器,方便在运行期间将代理类加载到内存
         * Class<?>[] interfaces 就是切入点（pointcut）的集合，由于是运行期间，所以的话
         * 需要通过目标对象的字节码实例去获取，方式如下：
         * 1. target.getClass().getInterfaces() 这种方式只能获取到自己类里面定义的方法，
         *    不能获取从父类或祖类继承过来的方法
         * 2. new Class[]{target.class}
         * InvocationHandler h 拦截处理类,运行期间拦截到目标类的方法后,将要进行什么样的逻辑处理
         *  1.一般使用匿名内部类的方式实现
         *  2.也可以使用它的自定义实现类
         *
         */
        Myservice proxyService = (Myservice) Proxy.newProxyInstance(Myservice.class.getClassLoader(),
                myservice.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();
                        Object object =  method.invoke(myservice,args);
                        advice.after();
                        return object;
                    }
                });

        System.out.println(proxyService.listenSongs("童话镇"));
        proxyService.singSongs();
        }
}
