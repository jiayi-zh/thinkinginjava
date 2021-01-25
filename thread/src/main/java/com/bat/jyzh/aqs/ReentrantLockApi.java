package com.bat.jyzh.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@link java.util.concurrent.locks.ReentrantLock} 源码剖析
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 11:12
 **/
public class ReentrantLockApi {

    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static final Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        new Thread(() -> {
            reentrantLock.lock();
            System.out.printf("condition wait: %s %n", Thread.currentThread().getName());
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
            System.out.printf("condition sginal: %s %n", Thread.currentThread().getName());
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(5);

                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                reentrantLock.unlock();
            }
        }).start();

        countDownLatch.await();
    }

    /**
     * {@link java.util.concurrent.locks.ReentrantLock} 基础 APi 测试
     *
     * @author ZhengYu
     */
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

        while (true) {

        }
    }
}
