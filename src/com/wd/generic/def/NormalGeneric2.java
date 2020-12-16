package com.wd.generic.def;

/**
 * 泛型类，多泛型参数
 * @param <T>
 * @param <K>
 */
public class NormalGeneric2<T, K> {

    private T data;
    private K result;

    public NormalGeneric2() {

    }

    public NormalGeneric2(T data, K result) {
        this.data = data;
        this.result = result;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public K getResult() {
        return result;
    }

    public void setResult(K result) {
        this.result = result;
    }

    public static void main(String[] args) {
        NormalGeneric2 normalGeneric = new NormalGeneric2<String, Integer>();
        normalGeneric.setData("Hello");
        System.out.println(normalGeneric.getData());
        normalGeneric.setResult(99);
        System.out.println(normalGeneric.getResult());
    }

}
