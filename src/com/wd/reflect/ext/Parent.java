package com.wd.reflect.ext;

/**
 * 测试类，父类
 */
public class Parent {

    private int privateParentField = 0;
    protected String protectedParentField = "Parent";
    public double publicParentField = 99;
    boolean defaultParentField = false;

    public Parent() {
        System.out.println("Parent()");
    }

    public Parent(boolean defaultParentField) {
        this.defaultParentField = defaultParentField;
        System.out.println("Parent(), defaultParentField: " + defaultParentField);
    }

//    public int getPrivateParentField() {
//        System.out.println("getPrivateParentField()");
//        return privateParentField;
//    }
//
//    public void setPrivateParentField(int privateParentField) {
//        this.privateParentField = privateParentField;
//        System.out.println("setPrivateParentField(), privateParentField: " + privateParentField);
//    }
//
//    public String getProtectedParentField() {
//        System.out.println("getProtectedParentField()");
//        return protectedParentField;
//    }
//
//    public void setProtectedParentField(String protectedParentField) {
//        this.protectedParentField = protectedParentField;
//        System.out.println("setProtectedParentField()");
//    }
//
//    public double getPublicParentField() {
//        System.out.println("getPublicParentField()");
//        return publicParentField;
//    }
//
//    public void setPublicParentField(double publicParentField) {
//        this.publicParentField = publicParentField;
//        System.out.println("setPublicParentField()");
//    }
//
//    public boolean isDefaultParentField() {
//        System.out.println("isDefaultParentField()");
//        return defaultParentField;
//    }
//
//    public void setDefaultParentField(boolean defaultParentField) {
//        this.defaultParentField = defaultParentField;
//        System.out.println("setDefaultParentField()");
//    }

    private void privateParentMethod() {
        System.out.println("privateParentMethod()");
    }

    protected void protectedParentFMethod() {
        System.out.println("protectedParentFMethod()");
    }

    public void publicParentMethod() {
        System.out.println("publicParentMethod()");
    }

    void defaultParentMethod() {
        System.out.println("defaultParentMethod()");
    }

    @Override
    public String toString() {
        return "Parent{" +
                "privateParentField=" + privateParentField +
                ", protectedParentField='" + protectedParentField + '\'' +
                ", publicParentField=" + publicParentField +
                ", defaultParentField=" + defaultParentField +
                '}';
    }
}
