package com.wd.proxy.normal;

import com.wd.proxy.source.food.IFood;

/**
 * 食物代理类
 * 作用：用户只需要通过代理商购买食物，而不需要去农田里购买
 */
public class NormalFoodProxy implements IFood {

    private IFood food;

    public NormalFoodProxy(IFood food) {
        this.food = food; // 设置具体代理商
    }

    /**
     * 通过委托代理商购买商品
     * 好处：可以对商品进行加工处理
     */
    @Override
    public void buyFood() {
        beforeSale();
        food.buyFood();
        afterSale();
    }

    private void beforeSale() {
        System.out.println("代理商检查食物是否安全");
    }

    private void afterSale() {
        System.out.println("代理商提供送货上门服务");
    }

}
