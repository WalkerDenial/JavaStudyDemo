package com.wd.reflect.ext;

import java.lang.reflect.Constructor;

/**
 * 构造方法测试
 */
public class ConstructTest {

    public static void main(String[] args) {
        try {
            String className = "com.wd.reflect.ext.Child";
            Class clazz = Class.forName(className);
            // 获取所有构造方法
            System.out.println("get construct method");
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor item : constructors) {
                System.out.println(item);
            }

            // 获取某一个 Constructor 对象
            Constructor constructor = clazz.getConstructor(boolean.class);
            System.out.println(constructor);

            // 调用构造器的 newInstance() 方法创建对象
            Child child = (Child) constructor.newInstance(false);
            System.out.println(child.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
