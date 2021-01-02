package com.wd.concurrent.syn;

public class TestWN {

    private static Express express = new Express(10, Express.CITY);

    private static class CheckKm extends Thread {
        @Override
        public void run() {
            express.waitKm();
        }
    }

    private static class CheckSite extends Thread {
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new CheckKm().start();
        }
        for (int i = 0; i < 3; i++) {
            new CheckSite().start();
        }
        Thread.sleep(1000);
        express.changeKM();
//        Thread.sleep(1000);
//        express.changeSite();
    }

}
