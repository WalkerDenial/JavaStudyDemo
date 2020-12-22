package com.wd.reflect.ext;

import java.lang.reflect.Field;

/**
 * 属性获取测试
 */
public class FieldTest {

    public static void main(String[] args) {
        try {
            String className = "com.wd.reflect.ext.Child";
            Class clazz = Class.forName(className);
            Child child = (Child) clazz.newInstance();

            // 1. 获取类及其父类所有 public 属性
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("---------------");

            // 2. 获取当前类的所有属性
            fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("---------------");

            // 3. 获取指定属性
            Field field = clazz.getDeclaredField("privateChildField");
            field.setAccessible(true);
            // 输出属性值
            System.out.println(field.get(child));
            // 修改属性值
            field.set(child, -1);
            System.out.println(field.get(child));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
