package com.wd.generic.inherit;

public class Pair<T> {

    private T one;
    private T two;

    public T getOne() {
        return one;
    }

    public void setOne(T one) {
        this.one = one;
    }

    public T getTwo() {
        return two;
    }

    public void setTwo(T two) {
        this.two = two;
    }

    private static <T> void set(Pair<Employee> p) {

    }

    public static void main(String[] args) {
        // Pair<Employee> 和 Pair<Worker> 没有任何继承关系
        Pair<Employee> employeePair = new Pair<>();
        Pair<Worker> workerPair = new Pair<>();

        // Pair<Employee> employeePair2 = new Pair<Worker>();

        Employee employee = new Worker();

        Pair<Employee> pair = new ExtendPair<>();
        set(employeePair);
        // set(workerPair);
    }

    /**
     * 泛型类可以继承或者扩展其他泛型类，比如 List 和 ArrayList
     */
    private static class ExtendPair<T> extends Pair<T> {

    }

}
