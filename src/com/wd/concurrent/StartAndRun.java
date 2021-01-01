package com.wd.concurrent;

public class StartAndRun {

    private static class ThreadRun extends Thread {
        @Override
        public void run() {
            int i = 10;
            while (i > 0) {
                try {
                    sleep(1000);
                    System.out.println("I'm " + Thread.currentThread().getName() + " and now the i = " + i--);
                    ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class User {
        public void us() {

        }
    }

    public static void main(String[] args) {
        ThreadRun threadRun = new ThreadRun();
        threadRun.setName("beCalled");
//        threadRun.run(); // 执行线程为主线程，与普通方法无异
        threadRun.start(); // 执行线程为 beCalled
    }

}
