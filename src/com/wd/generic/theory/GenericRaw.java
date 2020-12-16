package com.wd.generic.theory;

import java.util.ArrayList;

public class GenericRaw<T extends ArrayList&Comparable> {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
