package com.wd.reflect.ext;

import java.lang.reflect.Method;

/**
 * 方法获取测试
 */
public class MethodTest {

    public static void main(String[] args) {
        try {
            String className = "com.wd.reflect.ext.Child";
            Class clazz = Class.forName(className);

            // 1. 获取类及其父类所有 public 方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println("---------------");

            // 2. 获取当前类的所有方法
            methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }

            System.out.println("---------------");

            // 3. 获取指定方法
            Method method = clazz.getDeclaredMethod("privateChildMethod");
            System.out.println(method);
            method.setAccessible(true);
            method.invoke(clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
