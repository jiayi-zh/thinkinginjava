package com.bat.jyzh.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.locks.ReentrantLock}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 11:12
 **/
public class ReentrantLockApi {

    private static final ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            System.out.printf("wait condition: %s %n");
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();

    }

    private static void testReentrantLock() {
        new Thread(() -> {
            while (true) {
                System.out.printf("%d %d %b %n", reentrantLock.getHoldCount(), reentrantLock.getQueueLength(), reentrantLock.hasQueuedThreads());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                try {
                    Thread.sleep(5000);
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
