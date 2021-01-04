package com.wd.clazz;

/**
 * 从字节码层面分析 i++ 和 ++i 为什么不同
 */
public class AnalyseBytecode {

    public static void main(String[] args) {
        int i = 0;
        int num = i++;
        System.out.println("num: " + num);
        num = ++i;
        System.out.println("num: " + num);
    }

}
