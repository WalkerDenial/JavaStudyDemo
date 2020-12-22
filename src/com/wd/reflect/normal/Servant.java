package com.wd.reflect.normal;

/**
 * 测试类
 */
public class Servant {

    public boolean service(String message) {
        System.out.println("message: " + message);
        return true;
    }

    @Override
    public String toString() {
        return "Try your best.";
    }

}
