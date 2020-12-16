package com.wd.generic.typelimit;

/**
 * 类上泛型限定范围
 * @param <T>
 */
public class ClassBorder<T extends Comparable> {

    private T data;

    public ClassBorder() {
    }

    public ClassBorder(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T min(T outer) {
        return data.compareTo(outer) > 0 ? outer : data;
    }

    public static void main(String[] args) {
        ClassBorder classBorder = new ClassBorder();
        classBorder.setData(1);
        System.out.println(classBorder.min(2));
    }

}
