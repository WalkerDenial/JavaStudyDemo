package com.wd.gc;

import java.lang.ref.WeakReference;

/**
 * 测试 GC 信息
 */
public class SimpleGCTest {

    public static void main(String[] args) {
        Object obj = new Object();
        WeakReference<Object> refObj = new WeakReference(obj); // 这里创建一个对象
        obj = null;
        System.out.println("obj is " + refObj); // 输出 obj 的信息
        System.gc(); // 调用一次 GC
        System.out.println("obj is " + refObj); // 输出 obj 的信息
    }

}
