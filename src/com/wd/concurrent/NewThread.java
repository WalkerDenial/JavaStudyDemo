package com.wd.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class NewThread {

    private static class UseThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("I am extends Thread");
        }
    }

    private static class UseRun implements Runnable {

        @Override
        public void run() {
            System.out.println("I am implements Runnable");
        }

    }

    private static class UseCall implements Callable<String> {

        @Override
        public String call() {
            System.out.println("I am implements Callable");
            return "Call result";
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseThread useThread = new UseThread();
        useThread.start();

        UseRun useRun = new UseRun();
        new Thread(useRun).start();

        UseCall useCall = new UseCall();
        FutureTask<String> futureTask = new FutureTask<>(useCall);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }

}
