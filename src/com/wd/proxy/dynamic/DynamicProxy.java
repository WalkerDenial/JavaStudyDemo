package com.wd.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object factory;

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public Object getFactory() {
        return factory;
    }

    /**
     * 通过 Proxy 获得动态代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    /**
     * 通过动态代理方法进行增强
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
        Object result = method.invoke(factory, args);
        doAfter();
        return result;
    }

    private void doBefore() {
        System.out.println("提供代理前服务");
    }

    private void doAfter() {
        System.out.println("提供代理后服务");
    }

}
