package com.wd.generic.def;

/**
 * 泛型类
 * @param <T>
 */
public class NormalGeneric<T> {

    private T data;

    public NormalGeneric() {

    }

    public NormalGeneric(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        NormalGeneric normalGeneric = new NormalGeneric<String>();
        normalGeneric.setData("Hello");
        System.out.println(normalGeneric.getData());
    }

}
