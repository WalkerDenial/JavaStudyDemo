package com.wd.proxy;

import com.wd.proxy.normal.NormalFoodProxy;
import com.wd.proxy.normal.NormalToyProxy;
import com.wd.proxy.source.food.BananaFood;
import com.wd.proxy.source.food.IFood;
import com.wd.proxy.source.food.RiceFood;
import com.wd.proxy.source.toy.BallToy;
import com.wd.proxy.source.toy.CarToy;
import com.wd.proxy.source.toy.IToy;

/**
 * 静态代理测试
 */
public class NormalProxyTest {

    /**
     * 优点：
     * 1. 通过代理可以提供增值服务（扩展更多信息）
     * 2. 通过代理可以不需要知道具体实现细节
     *
     * 缺点：
     * 1. 增加一个新的操作，需要增加新的接口，违反开闭原则，可扩展性差
     * 2. 虽然不需要知道具体实现细节，但是需要知道具体实现类，造成类的额外负担
     *
     * @param args
     */
    public static void main(String[] args) {
        // 通过代理购买
        IFood food = new NormalFoodProxy(new RiceFood());
        food.buyFood();

        food = new NormalFoodProxy(new BananaFood());
        food.buyFood();

        IToy toy = new NormalToyProxy(new CarToy());
        toy.bugToy();

        toy = new NormalToyProxy(new BallToy());
        toy.bugToy();
    }

}
