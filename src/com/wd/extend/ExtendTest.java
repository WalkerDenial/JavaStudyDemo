package com.wd.extend;

import com.wd.extend.source.Child;
import com.wd.extend.source.Parent;

public class ExtendTest {

    /**
     * 由输出结果可知，在创建对象时，先创建父类，然后再创建子类
     * @param args
     */
    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println("--------------");
        Parent parent1 = new Child();
        System.out.println("--------------");
        Child child = new Child();
    }

}
