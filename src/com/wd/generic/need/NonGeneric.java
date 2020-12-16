package com.wd.generic.need;

/**
 * 没有使用泛型时的测试代码
 */
public class NonGeneric {

    /**
     * Add int number
     *
     * @param x
     * @param y
     * @return
     */
    public int addInt(int x, int y) {
        return x + y;
    }

    /**
     * Add float number
     *
     * @param x
     * @param y
     * @return
     */
    public float addFloat(float x, float y) {
        return x + y;
    }

    public static void main(String[] args) {
        NonGeneric nonGeneric = new NonGeneric();
        System.out.println(nonGeneric.addInt(1, 2));
        System.out.println(nonGeneric.addFloat(1f, 2f));
        /**
         * 由于没有定义 double 的 add 方法，因此无法通过编译
         */
        // System.out.println(nonGeneric.addFloat(1d, 2d));
    }

}
