package com.wd.reflect.ext;

import java.lang.reflect.Method;

public class MultipleTest {

    /**
     * 通过反射某一个对象看看是否会影响已有实例
     * @param args
     */
    public static void main(String[] args) {
        try {
            Parent parent1 = new Parent();
            Parent parent2 = new Parent();
            Class clazz = Parent.class;
            Method method = clazz.getDeclaredMethod("privateParentMethod");
            method.setAccessible(true);
            method.invoke(clazz.newInstance(), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
