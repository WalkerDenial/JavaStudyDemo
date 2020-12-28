package com.wd.reflect.ext;

/**
 * Enum 单例防攻击测试
 */
public enum EnumSingletonTest {

    INSTANCE {
        @Override
        void showMessage() {
            System.out.println("This is showMessage method.");
        }
    };

    abstract void showMessage();

    public static void main(String[] args) {
        // 注意，单例不能被实例化哟
        // EnumSingletonTest test = new EnumSingletonTest();

        EnumSingletonTest test1 = EnumSingletonTest.INSTANCE;
        test1.showMessage();

        // 尝试通过反射调用
        try {
            Class clazz = test1.getClass();
            EnumSingletonTest test2 = (EnumSingletonTest) clazz.newInstance();
            test2.showMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 反射会失败，可以查看一下 newInstance() 源码
         *
         * if ((clazz.getModifiers() & Modifier.ENUM) != 0)
         *             throw new IllegalArgumentException("Cannot reflectively create enum objects");
         *
         * 判断如果是枚举，直接抛出异常，所以无法通过创建枚举对象，因此也就无法使用反射修改值
         */
    }

}
