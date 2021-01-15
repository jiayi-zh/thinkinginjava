package com.bat.jyzh.notify;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * {@link java.util.concurrent.locks.LockSupport} API
 *
 * @author ZhengYu
 * @version 1.0 2021/1/15 13:57
 **/
public class LockSupportApi {
    private static final Object OBJ = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("OBJ memory address: " + OBJ);

        Thread t = new Thread(() -> {
            System.out.printf("thread: %s park... %n", Thread.currentThread().getName());
//            LockSupport.park(OBJ); // 挂起线程

            LockSupport.parkNanos(OBJ, TimeUnit.SECONDS.toNanos(1));

            System.out.printf("thread: %s unPark... %n", Thread.currentThread().getName());
        });

        t.start();

        TimeUnit.SECONDS.sleep(3);

        // 获取已经挂起的线程设置的blocker对象
        Object blocker = LockSupport.getBlocker(t);
        System.out.printf("Thread: %s parkBlocker field value: %s %n", t.getName(), blocker);

//        LockSupport.unpark(t);
    }
}
