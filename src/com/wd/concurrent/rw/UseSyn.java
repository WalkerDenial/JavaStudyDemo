package com.wd.concurrent.rw;

public class UseSyn implements GoodsService {

    private GoodsInfo goodsInfo;

    public UseSyn(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    @Override
    public synchronized GoodsInfo getNum() {
        try {
            Thread.sleep(5);
            return this.goodsInfo;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public synchronized void setNum(int number) {
        try {
            Thread.sleep(5);
            goodsInfo.changeNumber(number);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
