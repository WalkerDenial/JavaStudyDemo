package com.wd.generic.restrict;

public class Restrict<T> {

    private T data;

    /**
     * 不能实例化泛型变量
     */
    public Restrict() {
        // this.data = new T();
    }

    /**
     * 静态域或者静态方法中不能引用类型变量
     */
    // private static T instance;

    /**
     * 静态方法是泛型方法的情况下可以使用类型变量
     */
    public static <T> T getInstance() {
        return null;
    }

    public static void main(String[] args) {
        // 泛型类型不能是基础类型, 基础类型不是对象
        // Restrict<double> restrict;

        // instanceof 会失效，因为泛型擦除机制
        Restrict<Double> restrict = new Restrict<>();
//        if(restrict instanceof Restrict<Double>) {
//
//        }

        // 泛型擦除后 泛型的类型是相同的
        Restrict<String> restrictString = new Restrict<>();
        System.out.println(restrict.getClass() == restrictString.getClass()); // true
        System.out.println(restrict.getClass().getName());
        System.out.println(restrictString.getClass().getName());

        // 泛型不能成为数组
        Restrict<Double>[] restrictArray; // 可以定义
        // Restrict<Double>[] restricts = new Restrict<Double>[10]; // 不能实例化
    }

}
