package com.java8.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * com.java8.proxy
 * <strong>描述：</strong>
 * <strong>功能：</strong>
 * <strong>使用场景：</strong>
 * <strong>注意事项：</strong>
 *
 * @author: wangjun
 * @date: 2018/10/18.
 */
interface Subject{
    void action();
}

class RealSubject implements Subject{
    @Override
    public void action() {
        System.out.println("我的被代理类");
    }
}


class MyInvocationHandler implements InvocationHandler{

    Object object;

    public Object blind(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}




public class proxyTest {
}
