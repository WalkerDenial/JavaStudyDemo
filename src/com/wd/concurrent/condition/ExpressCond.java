package com.wd.concurrent.condition;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExpressCond {

    public static final String CITY = "ShangHai";

    private long km;
    private String site;
    private Lock lock = new ReentrantLock();
    private Condition kmCond = lock.newCondition();
    private Condition siteCond = lock.newCondition();

    public ExpressCond(long km, String site) {
        this.km = km;
        this.site = site;
    }

    public void changeSite() {
        lock.lock();
        try {
            this.site = "BeiJin";
            siteCond.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void changeKM() {
        System.out.println("changeKM start");
        lock.lock();
        try {
            this.km = new Random().nextInt(1000) + 100;
            kmCond.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("changeKM end");
    }

    public void waitKm() {
        System.out.println("waitKm start");
        lock.lock();
        try {
            while (this.km < 100) {
                try {
                    System.out.println(Thread.currentThread().getId() + " await, km: " + this.km);
                    kmCond.await();
                    System.out.println("check km thread[" + Thread.currentThread().getId() + "] is been notified");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The km is " + km + ", I will change db");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("waitKm end");
    }

    public void waitSite() {
        lock.lock();
        try {
            while (site.equals(CITY)) {
                try {
                    siteCond.await();
                    System.out.println("check site thread[" + Thread.currentThread().getId() + "] is been notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("The site is " + site + ", I will change db");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
