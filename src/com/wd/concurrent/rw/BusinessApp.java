package com.wd.concurrent.rw;

import java.util.Random;

public class BusinessApp {

    static final int readWriteRadio = 10; // 读写线程的比例
    static final int minThreadCount = 3; // 最少线程数

    // 读操作
    private static class ReadThread implements Runnable {
        private GoodsService goodsService;

        public ReadThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) { // 操作 100 次
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName() + "读取商品数据耗时：" + (System.currentTimeMillis() - start) + " ms");
        }
    }

    // 写操作
    private static class WriteThread implements Runnable {
        private GoodsService goodsService;

        public WriteThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }

        @Override
        public void run() {
            try {
                long start = System.currentTimeMillis();
                Random random = new Random();
                for (int i = 0; i < 10; i++) { // 操作 10 次
                    Thread.sleep(5);
                    goodsService.setNum(random.nextInt(10));
                }
                System.out.println(Thread.currentThread().getName() + "写商品数据耗时：" + (System.currentTimeMillis() - start) + " ms----");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GoodsInfo info = new GoodsInfo("CPU", 100000, 10000);
//        GoodsService service = new UseSyn(info); // 使用 synchronized 方式
         GoodsService service = new UseRwLock(info); // 使用 ReadWriteLock 方式
        for (int i = 0; i < minThreadCount; i++) {
            Thread writeThread = new Thread(new WriteThread(service));
            for (int i1 = 0; i1 < readWriteRadio; i1++) {
                Thread readThread = new Thread(new ReadThread(service));
                readThread.start();
            }
            Thread.sleep(5);
            writeThread.start();
        }
    }

}
