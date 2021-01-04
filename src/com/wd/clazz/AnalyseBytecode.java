package com.wd.clazz;

/**
 * 从字节码层面分析 i++ 和 ++i 为什么不同
 */
public class AnalyseBytecode {

    private int i = 0;

    private void addAtFront() {
        ++i;
    }

    private void addAtEnd() {
        i++;
    }

    public static void main(String[] args) {
        AnalyseBytecode analyseBytecode = new AnalyseBytecode();
        analyseBytecode.addAtFront();
        analyseBytecode.addAtEnd();
    }

}
