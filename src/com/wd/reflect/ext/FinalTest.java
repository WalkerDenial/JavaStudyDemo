package com.wd.reflect.ext;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * final 类型对象，通过反射尝试能否改变结果
 */
public class FinalTest {

    private static final Child child = new Child();

    private final Parent parent = new Parent();

    private static final int childAge = 10;

    private final int parentAge = 36;

    public static void main(String[] args) {
        try {
            Class clazz = FinalTest.class;
            FinalTest test = (FinalTest) clazz.newInstance();

            // 1. 修改 childAge 值
//            Field childAgeField = clazz.getDeclaredField("childAge");
//            System.out.println("before: childAge is " + childAgeField.get(test));
//            childAgeField.setAccessible(true);
//            childAgeField.set(test, 99);
//            System.out.println("after: childAge is " + childAgeField.get(test));

            // 2. 修改 parentAge 值
            Field parentAgeField = clazz.getDeclaredField("parentAge");
            System.out.println("before: parentAge is " + parentAgeField.get(test));
            parentAgeField.setAccessible(true);
            parentAgeField.set(test, 360);
            System.out.println("after: parentAge is " + parentAgeField.get(test));

            // 3. 将 child 置为空
//            Field childField = clazz.getDeclaredField("child");
//            System.out.println("before: childField is " + childField.get(test));
//            childField.setAccessible(true);
//            childField.set(test, null);
//            System.out.println("after: childField is " + childField.get(test));

            // 4. 尝试将 final Parent 置为空
            Field parentField = clazz.getDeclaredField("parent");
            System.out.println("before: parent is " + parentField.get(test));
            parentField.setAccessible(true);
            parentField.set(test, null);
            System.out.println("after: parent is " + parentField.get(test));

            // 3. 移除 final 然后将 child 置为空
            Field childField1 = clazz.getDeclaredField("child");
            System.out.println("before: childField is " + childField1.get(test));
            // 移除 final
            Field modifyField = Field.class.getDeclaredField("modifiers");
            modifyField.setAccessible(true);
            modifyField.setInt(childField1, childField1.getModifiers() & ~Modifier.FINAL);
            // 修改 child 值
            childField1.setAccessible(true);
            childField1.set(test, null);
            System.out.println("after: childField is " + childField1.get(test));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
