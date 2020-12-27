package com.wd.extend;

import com.wd.extend.source.Child;
import com.wd.extend.source.Parent;

public class ExtendTest {

    public static void main(String[] args) {
        Parent parent = new Parent();
        System.out.println("--------------");
        Parent parent1 = new Child();
        System.out.println("--------------");
        Child child = new Child();
    }

}
