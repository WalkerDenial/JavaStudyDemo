package com.wd.generic.wild;

import java.util.ArrayList;
import java.util.List;

public class WildTest2 {

    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(1f);
        numberList.add(1d);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        numberList.addAll(integerList);
        // integerList.addAll(numberList);

        // numberList = integerList; // 无法赋值

        List<? extends Number> numberList1 = new ArrayList<>();
        numberList.add(1);
        numberList.add(1f);
        numberList.add(1d);

        List<Integer> integerList1 = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        numberList1 = integerList1; // 由于使用了限定通配符，可以进行赋值
    }

}
