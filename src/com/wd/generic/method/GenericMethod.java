package com.wd.generic.method;

/**
 * 泛型方法测试
 */
public class GenericMethod {

    /**
     * 泛型方法
     *
     * @param a
     * @param <T>
     * @return
     */
    public <T> T genericMethod(T... a) {
        return a == null ? null : a[a.length / 2];
    }

    public void test(int x, int y) {
        System.out.println(x + y);
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        genericMethod.test(11, 22);
        System.out.println(genericMethod.genericMethod("A", "B", "C"));
        // 该方法为泛型方法，所以无论是 String 还是 int 都不会出问题
        System.out.println(genericMethod.genericMethod(1, 2, 3, "4"));
    }

}
