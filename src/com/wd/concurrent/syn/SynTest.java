package com.wd.concurrent.syn;

public class SynTest {

    private long count = 0;

    private Object obj = new Object();

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    // 对 count 进行累加，由于没有加锁，计算的结果会偏小，不正确
    public void incCount1() {
        count++;
    }

    // 加方法锁
    public synchronized void incCount2() {
        count++;
    }

    // 加指定对象锁
    public void incCount3() {
        synchronized (obj) {
            count++;
        }
    }

    // 加当前对象锁
    public void incCount4() {
        synchronized (this) {
            count++;
        }
    }

    // 开启线程进行操作
    private static class Count extends Thread {
        private SynTest synTest;

        public Count(SynTest test) {
            this.synTest = test;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synTest.incCount1();
            }
        }
    }

    public static void main(String[] args) {
        SynTest synTest = new SynTest();
        // 启动两个线程对 count 进行操作
        Count thread1 = new Count(synTest);
        Count thread2 = new Count(synTest);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(synTest.getCount());
    }

}
