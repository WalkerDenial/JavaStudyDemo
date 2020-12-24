package com.wd.proxy.normal;

import com.wd.proxy.source.toy.IToy;

/**
 * 玩具代理类
 * 用户可以通过代理商购买玩具，而不需要自己跑到工厂购买
 */
public class NormalToyProxy implements IToy {

    private IToy toy;

    public NormalToyProxy(IToy toy) {
        this.toy = toy; // 设置具体代理商
    }

    /**
     * 通过委托代理商购买商品
     * 好处：可以对商品进行加工处理
     */
    @Override
    public void bugToy() {
        beforeSale(); // 售前服务
        toy.bugToy();
        afterSale(); // 售后服务
    }

    private void beforeSale() {
        System.out.println("代理商检查玩具是否损坏");
    }

    private void afterSale() {
        System.out.println("代理商提供玩具维修服务");
    }

}
