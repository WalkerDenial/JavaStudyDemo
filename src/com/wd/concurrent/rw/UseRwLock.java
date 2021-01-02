package com.wd.concurrent.rw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class UseRwLock implements GoodsService {

    private GoodsInfo goodsInfo;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    public UseRwLock(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public GoodsInfo getNum() {
        readLock.lock();
        try {
            Thread.sleep(5);
            return goodsInfo;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        return null;
    }

    @Override
    public void setNum(int number) {
        writeLock.lock();
        try {
            Thread.sleep(5);
            goodsInfo.changeNumber(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

}
