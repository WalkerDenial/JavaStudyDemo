package com.wd.concurrent;

public class UseJoin {

    static class JumpQueue implements Runnable {
        private Thread thread;// 用来插队的线程

        public JumpQueue(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                System.out.println(thread.getName() + " will be join before " + Thread.currentThread().getName());
                thread.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminated.");
        }
    }

    public static void main(String[] args) {
        Thread previous = Thread.currentThread(); // 当前是主线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        try {
            Thread.sleep(2000); // 让主线程休眠 2 秒
            System.out.println(Thread.currentThread().getName() + " terminated.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
