package com.bat.jyzh.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * {@link java.util.concurrent.locks.ReentrantReadWriteLock}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/1 21:14
 **/
public class ReentrantReadWriteLockApi {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().lock();

        new Thread(() -> reentrantReadWriteLock.readLock().lock()).start();

        TimeUnit.SECONDS.sleep(10);
//        reentrantReadWriteLock.readLock().unlock();
//
//        reentrantReadWriteLock.writeLock().lock();
//        reentrantReadWriteLock.writeLock().unlock();
    }
}
