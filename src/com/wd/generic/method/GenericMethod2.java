package com.wd.generic.method;

/**
 * 泛型方法 2
 */
public class GenericMethod2 {

    public class Generic<T> {
        private T key;

        public Generic(T key) {
            this.key = key;
        }

        /**
         * 不是泛型方法，只是一个普通方法，只是返回类型恰好是泛型而已
         *
         * @return
         */
        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        /**
         * 错误，因为未声明 E
         *
         * @param
         * @return
         */
//        public E setKey(E key) {
//            this.key = key;
//        }

        /**
         * 是泛型方法
         *
         * @param container
         * @param <T>
         * @param <K>
         * @return
         */
        public <T, K> K showKeyName(Generic<T> container) {
            return null;
        }

    }

    /**
     * 不是泛型方法，只是一个普通的方法
     * 只是使用了泛型类型做形参而已
     *
     * @param obj
     */
    public void show(Generic<Number> obj) {

    }

    public <T, E> T show(E e) {
        return null;
    }

    /**
     * 错误
     * 类型 T 未定义
     *
     * @param
     */
//    public void show (T obj) {
//
//    }

    public static void main(String[] args) {

    }

}
