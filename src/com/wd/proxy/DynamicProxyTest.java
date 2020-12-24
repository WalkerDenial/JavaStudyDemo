package com.wd.proxy;

import com.wd.proxy.dynamic.DynamicProxy;
import com.wd.proxy.source.food.IFood;
import com.wd.proxy.source.food.RiceFood;
import com.wd.proxy.source.toy.CarToy;
import com.wd.proxy.source.toy.IToy;

public class DynamicProxyTest {

    public static void main(String[] args) {
        // 初始化动态代理类
        DynamicProxy proxy = new DynamicProxy();

        // 代理 RiceFood（动态代理类里面没有实现 IFood 接口）
        proxy.setFactory(new RiceFood());
        IFood rice = (IFood) proxy.getProxyInstance();
        rice.buyFood();

        // 代理 CarToy（动态代理类里面没有实现 IToy 接口）
        proxy.setFactory(new CarToy());
        IToy toy = (IToy) proxy.getProxyInstance();
        toy.bugToy();
    }

}
