package com.wd.generic.def;

/**
 * 泛型接口实现 1
 * @param <T>
 */
public class GeneratorImpl<T> implements Generator<T>{

    /**
     * 该类还是泛型类，因此返回类型还是 T
     * @return
     */
    @Override
    public T next() {
        return null;
    }

}
