package com.wd.concurrent;

public class EndThread {

    private static class UseThread extends Thread {

        public UseThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            super.run();
//            while (true) { // 实际上不会中断
            while (!isInterrupted()) { // 这种会中断
                System.out.println(Thread.currentThread().getName() + " is running");
                System.out.println(Thread.currentThread().getName() + " inner interrupt flag = " + isInterrupted());
            }
            System.out.println(Thread.currentThread().getName() + " interrupt flag = " + isInterrupted());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        UseThread thread = new UseThread("endThread");
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }

}
