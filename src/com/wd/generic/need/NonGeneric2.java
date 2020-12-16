package com.wd.generic.need;

import java.util.ArrayList;
import java.util.List;

/**
 * 没有使用泛型时的测试代码
 */
public class NonGeneric2 {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("Hello");
        list.add("Java");
        list.add(100); // 由于没有使用泛型约束，因此此处可以通过编译

        /**
         * 编译能通过，但是 100 无法强转为 String 类型，因此会报错
         */
        for (int i = 0; i < list.size(); i++) {
            /**
             * Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
             * 	at com.wd.generic.need.NonGeneric2.main(NonGeneric2.java:21)
             */
            String value = (String) list.get(i);
            System.out.println("value is " + value);
        }
    }

}
