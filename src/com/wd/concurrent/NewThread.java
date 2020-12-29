package com.wd.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 启用线程的 3 种方式
 */
public class NewThread {

    /**
     * 1. 派生 Thread
     */
    private static class UseThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("I am extends Thread");
        }
    }

    /**
     * 2. 实现 Runnable
     */
    private static class UseRun implements Runnable {

        @Override
        public void run() {
            System.out.println("I am implements Runnable");
        }

    }

    /**
     * 3. 实现 Callable，有返回值
     */
    private static class UseCall implements Callable<String> {

        @Override
        public String call() {
            System.out.println("I am implements Callable");
            return "Call result";
        }

    }

    /**
     * 测试方法
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     *
     * 实际而言，只有 Thread 才能代表线程；
     * Runnable、Callable 表示的是任务
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /**
         * 基于 Thread 派生启动线程
         */
        UseThread useThread = new UseThread();
        useThread.start();

        /**
         * 基于 Runnable 启动线程
         */
        UseRun useRun = new UseRun();
        new Thread(useRun).start();

        /**
         * 通过 Callable 可以获取回调信息
         */
        UseCall useCall = new UseCall();
        FutureTask<String> futureTask = new FutureTask<>(useCall);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
