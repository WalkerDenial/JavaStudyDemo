package com.wd.generic.restrict;

public class ExceptionRestrict {

    /**
     * 泛型类不能 extends Exception/Throwable
     */
    // private class Problem<T> extends Exception{}

    /**
     * 不能捕获泛型类对象
     */
//    public <T extends Throwable> void doWork(T t) {
//        try {
//
//        } catch (T e){
//
//        }
//    }
    public <T extends Throwable> void doWorkSuccess(T t) throws T {
        try {

        } catch (Throwable e) {
            throw e;
        }
    }


}
