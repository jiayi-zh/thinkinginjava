package com.bat.jyzh;

import java.util.concurrent.TimeUnit;

/**
 * 临时测试
 *
 * @author ZhengYu
 * @version 1.0 2021/2/4 12:17
 **/
public class TempTest {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
//                int i = 0;
//                while (!stopRequested) {
//                    i++;
//                }
                try {
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        backgroundThread.start();
//        System.out.println(Thread.currentThread().getName());
//        TimeUnit.SECONDS.sleep(1);
//        stopRequested = true;
    }
}
