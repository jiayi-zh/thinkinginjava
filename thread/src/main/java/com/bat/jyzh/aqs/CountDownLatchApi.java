package com.bat.jyzh.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * {@link java.util.concurrent.CountDownLatch}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/2 14:56
 **/
public class CountDownLatchApi {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " deal ...");

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " countDown ...");

                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();
        System.out.println("main go ...");
    }
}
