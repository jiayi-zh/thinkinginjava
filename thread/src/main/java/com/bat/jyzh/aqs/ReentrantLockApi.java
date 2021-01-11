package com.bat.jyzh.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 11:12
 **/
public class ReentrantLockApi {

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.printf("%d %d %b %n", reentrantLock.getHoldCount(), reentrantLock.getQueueLength(), reentrantLock.hasQueuedThreads());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }).start();
        }

        for (; ; ) {
        }
    }
}
