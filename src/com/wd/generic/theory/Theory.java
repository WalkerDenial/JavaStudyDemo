package com.wd.generic.theory;

import java.util.HashMap;
import java.util.Map;

public class Theory {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "99");
        System.out.println(map.get("hello")); // 此处观察字节码，会有自动强转
    }

}
