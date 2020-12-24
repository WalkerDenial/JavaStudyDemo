package com.wd.proxy;

import com.wd.proxy.dynamic.DynamicProxy;
import com.wd.proxy.source.food.IFood;
import com.wd.proxy.source.food.RiceFood;
import com.wd.proxy.source.toy.CarToy;
import com.wd.proxy.source.toy.IToy;
import com.wd.proxy.util.ProxyUtil;

import java.lang.reflect.Method;

public class DynamicProxyTest {

    public static void main(String[] args) {
        // 初始化动态代理类
        DynamicProxy proxy = new DynamicProxy();

        // 代理 RiceFood（动态代理类里面没有实现 IFood 接口）
        RiceFood riceFood = new RiceFood();
        proxy.setFactory(riceFood);
        IFood riceProxy = (IFood) proxy.getProxyInstance();
        riceProxy.buyFood();

        // 代理 CarToy（动态代理类里面没有实现 IToy 接口）
        CarToy carToy = new CarToy();
        proxy.setFactory(carToy);
        IToy toyProxy = (IToy) proxy.getProxyInstance();
        toyProxy.bugToy();

        // 从内存中获取动态代理生成的类
        ProxyUtil.generateClassFile(riceFood.getClass(), riceProxy.getClass().getSimpleName());
        ProxyUtil.generateClassFile(carToy.getClass(), toyProxy.getClass().getSimpleName());
        System.out.println("--------------------");
        for (Method item : riceProxy.getClass().getDeclaredMethods()) {
            System.out.println(item.getName());
        }
        System.out.println("--------------------");
        for (Method item : toyProxy.getClass().getDeclaredMethods()) {
            System.out.println(item.getName());
        }
    }

}
