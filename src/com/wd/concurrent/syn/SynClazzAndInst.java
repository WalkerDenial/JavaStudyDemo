package com.wd.concurrent.syn;

public class SynClazzAndInst {

    // 使用类锁的线程
    private static class SynClass extends Thread {
        @Override
        public void run() {
            System.out.println("SynClass is running...");
            synClass();
        }
    }

    // 类锁，实际上锁的是类的 class 对象
    private static synchronized void synClass() {
        try {
            Thread.sleep(1);
            System.out.println("SynClass going...");
            Thread.sleep(1);
            System.out.println("SynClass end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 使用对象锁的线程
    private static class SynObject implements Runnable {

        private SynClazzAndInst synClazzAndInst;

        public SynObject(SynClazzAndInst inst) {
            this.synClazzAndInst = inst;
        }

        @Override
        public void run() {
            System.out.println("SynObject is running... " + synClazzAndInst);
            synClazzAndInst.instance();
        }
    }

    // 使用对象锁的线程
    private static class SynObject2 implements Runnable {

        private SynClazzAndInst synClazzAndInst;

        public SynObject2(SynClazzAndInst inst) {
            this.synClazzAndInst = inst;
        }

        @Override
        public void run() {
            System.out.println("SynObject2 is running... " + synClazzAndInst);
            synClazzAndInst.instance2();
        }
    }

    // 锁对象
    private synchronized void instance() {
        try {
            Thread.sleep(3);
            System.out.println("SynObject going...");
            Thread.sleep(3);
            System.out.println("SynObject end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 锁对象
    private synchronized void instance2() {
        try {
            Thread.sleep(3);
            System.out.println("SynObject2 going...");
            Thread.sleep(3);
            System.out.println("SynObject2 end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SynClazzAndInst clazzAndInst = new SynClazzAndInst();
        Thread thread1 = new Thread(new SynObject(clazzAndInst));

        SynClazzAndInst clazzAndInst2 = new SynClazzAndInst();
        /**
         * 此处传入的与 thread1 是同一个对象，就会出现等待情况，一个线程执行完毕，
         * 另一个线程才能执行
         */
        Thread thread2 = new Thread(new SynObject2(clazzAndInst));
        /**
         * 此处传入的不是同一个对象，与 thread1 没有任何关系，无须等待 thread1 执行完毕了在执行
         */
//        Thread thread2 = new Thread(new SynObject2(clazzAndInst2));

        thread1.start();
        thread2.start();

        SynClass synClass = new SynClass();
        synClass.start();
    }

}
