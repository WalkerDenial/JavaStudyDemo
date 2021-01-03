package com.wd.concurrent.condition;

public class TestCond {

    private static ExpressCond express = new ExpressCond(0, ExpressCond.CITY);

    private static class CheckKm extends Thread {
        @Override
        public void run() {
            System.out.println("CheckKm run()");
            express.waitKm();
        }
    }

    private static class CheckSite extends Thread {
        @Override
        public void run() {
            System.out.println("CheckSite run()");
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
//        for (int i = 0; i < 3; i++) {
//            new CheckSite().start();
//        }
        Thread.sleep(1000);
        express.changeKM();
//        Thread.sleep(1000);
//        express.changeSite();
    }

}
