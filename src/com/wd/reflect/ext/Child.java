package com.wd.reflect.ext;

/**
 * 测试类，子类
 */
public class Child extends Parent {

    private int privateChildField = 0;
    protected String protectedChildField = "Child";
    public double publicChildField = 99;
    boolean defaultChildField = false;

    public Child() {
        System.out.println("Child()");
    }

    public Child(boolean defaultChildField) {
        this.defaultChildField = defaultChildField;
        System.out.println("Child(), defaultChildField: " + defaultChildField);
    }

    public int getPrivateChildField() {
        System.out.println("getPrivateChildField()");
        return privateChildField;
    }

    public void setPrivateChildField(int privateChildField) {
        this.privateChildField = privateChildField;
        System.out.println("setPrivateChildField()");
    }

    public String getProtectedChildField() {
        System.out.println("getProtectedChildField()");
        return protectedChildField;
    }

    public void setProtectedChildField(String protectedChildField) {
        this.protectedChildField = protectedChildField;
        System.out.println("setProtectedChildField()");
    }

    public double getPublicChildField() {
        System.out.println("getPublicChildField()");
        return publicChildField;
    }

    public void setPublicChildField(double publicChildField) {
        this.publicChildField = publicChildField;
        System.out.println("setPublicChildField()");
    }

    public boolean isDefaultChildField() {
        System.out.println("isDefaultChildField()");
        return defaultChildField;
    }

    public void setDefaultChildField(boolean defaultChildField) {
        this.defaultChildField = defaultChildField;
        System.out.println("setDefaultChildField()");
    }

    protected void privateChildMethod() {
        System.out.println("privateChildMethod()");
    }

    protected void protectedChildFMethod() {
        System.out.println("protectedChildFMethod()");
    }

    protected void publicChildMethod() {
        System.out.println("publicChildMethod()");
    }

    protected void defaultChildMethod() {
        System.out.println("defaultChildMethod()");
    }

    @Override
    public String toString() {
        return "Child{" +
                "privateChildField=" + privateChildField +
                ", protectedChildField='" + protectedChildField + '\'' +
                ", publicChildField=" + publicChildField +
                ", defaultChildField=" + defaultChildField +
                '}';
    }

}
