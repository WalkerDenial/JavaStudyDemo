package com.wd.reflect.ext;

/**
 * 单例防攻击测试
 */
public class SingletonTest {

    /**
     * 采用饿汉式方式
     */
    private static final SingletonTest INSTANCE = new SingletonTest();

    private SingletonTest() {
        // 检测当一存在实例时，抛出异常
        if (INSTANCE != null) throw new RuntimeException("fire the home");
    }

    public static SingletonTest getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        try {
            // 获取原始对象
            SingletonTest test = SingletonTest.getInstance();
            // 通过反射获取新对象
            Class clazz = SingletonTest.class;

            SingletonTest test1 = (SingletonTest) clazz.newInstance();
            // 判断两个对象是否相同
            System.out.println(test == test1);

            // 尝试通过反射先将 INSTANCE 置为空，从而避免 newInstance 抛出异常
//            Field field = clazz.getDeclaredField("INSTANCE");
//            field.setAccessible(true);
//
//            Field modifyField = Field.class.getDeclaredField("modifiers");
//            modifyField.setAccessible(true);
//            modifyField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
//
//            field.set(clazz, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
