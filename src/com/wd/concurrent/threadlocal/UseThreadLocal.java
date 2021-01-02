package com.wd.concurrent.threadlocal;

public class UseThreadLocal {

    static ThreadLocal<Integer> count = ThreadLocal.withInitial(() -> 1);

    public void startThreadArray() {
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestTask(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }

    private class TestTask implements Runnable {
        int id;

        public TestTask(int i) {
            this.id = i;
        }

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " :start");
            count.set(count.get() + id);
            System.out.println(threadName + " :" + count.get());
        }
    }

    public static void main(String[] args) {
        UseThreadLocal noThreadLocal = new UseThreadLocal();
        noThreadLocal.startThreadArray();
    }

}
