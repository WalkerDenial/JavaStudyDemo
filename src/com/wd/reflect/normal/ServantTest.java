package com.wd.reflect.normal;

public class ServantTest {

    public static void main(String[] args) {
        // 常规写法
        Servant servant = new Servant();
        servant.service("Hello");
        System.out.println(servant.toString());

        // 反射写法
        try {
            Class servantClass1 = Servant.class;
            Class servantClass2 = servant.getClass();
            Class servantClass3 = Class.forName("com.wd.reflect.normal.Servant");

            Servant reflectServant = (Servant) servantClass3.newInstance();
            reflectServant.service("Reflect");
            System.out.println(reflectServant.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
