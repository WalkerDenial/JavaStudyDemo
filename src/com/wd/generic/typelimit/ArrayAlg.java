package com.wd.generic.typelimit;

public class ArrayAlg {

    /**
     * 只有实现了 Comparable 接口的类型才能使用 compareTo 方法
     * 其中，如果有多个实现，最多只能有一个类，并且类必须写在最前面
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public static <T extends Comparable> T min(T a, T b) {
        return a.compareTo(b) > 0 ? b : a;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 2));
    }

}
