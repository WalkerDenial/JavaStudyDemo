package com.wd.generic.def;

/**
 * 泛型接口实现 2
 */
public class GeneratorImpl2 implements Generator<String> {

    /**
     * 此时泛型已确定了具体类型 String， 因此返回值为 String
     * @return
     */
    @Override
    public String next() {
        return null;
    }

}
