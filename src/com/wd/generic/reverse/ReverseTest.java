package com.wd.generic.reverse;

import com.wd.generic.typelimit.ClassBorder;
import sun.reflect.generics.reflectiveObjects.TypeVariableImpl;

import java.lang.reflect.Field;
import java.lang.reflect.TypeVariable;

/**
 * 通过反射获取泛型信息
 */
public class ReverseTest {

    public static void main(String[] args) {
        ClassBorder<String> genericType = new ClassBorder<>();
        genericType.setData("hello");
        System.out.println("restrict name is " + genericType.getClass().getName());

        try {
            Field data = genericType.getClass().getDeclaredField("data");
            System.out.println("data real class is: " + data.getGenericType().getTypeName());
            System.out.println("------------");
            for (TypeVariable<?> item : ((TypeVariableImpl) data.getGenericType()).getGenericDeclaration().getTypeParameters()) {
                System.out.println(item.getTypeName());
            }

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

}
