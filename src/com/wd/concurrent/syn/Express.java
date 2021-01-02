package com.wd.concurrent.syn;

import java.util.Random;

public class Express {

    public static final String CITY = "ShangHai";

    private long km;
    private String site;

    public Express(long km, String site) {
        this.km = km;
        this.site = site;
    }

    public synchronized void changeSite() {
        this.site = "BeiJin";
        notifyAll();
    }

    public synchronized void changeKM() {
        this.km = new Random().nextInt() + 100;
        notifyAll(); // 会通知所有线程
//        notify(); // 只会通知一个线程
    }

    public synchronized void waitKm() {
        while (km < 100) {
            try {
                wait();
                System.out.println("check km thread[" + Thread.currentThread().getId() + "] is been notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The km is " + km + ", I will change db");
    }

    public synchronized void waitSite() {
        while (site.equals(CITY)) {
            try {
                wait();
                System.out.println("check site thread[" + Thread.currentThread().getId() + "] is been notified");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("The site is " + site + ", I will change db");
    }

}
