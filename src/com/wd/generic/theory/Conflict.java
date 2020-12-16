package com.wd.generic.theory;

import java.util.List;

/**
 * 泛型擦除后，List<String> 与 List<Integer> 是相同的
 */
public class Conflict {

    public static void method(List<String> stringList) {
        System.out.println("List");
    }

//    public static void method(List<Integer> integerList) {
//        System.out.println("Integer");
//    }

}
