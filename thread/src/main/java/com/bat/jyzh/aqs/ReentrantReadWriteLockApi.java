package com.bat.jyzh.aqs;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * {@link java.util.concurrent.locks.ReentrantReadWriteLock}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/1 21:14
 **/
public class ReentrantReadWriteLockApi {
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        reentrantReadWriteLock.readLock().lock();
        reentrantReadWriteLock.readLock().unlock();

        reentrantReadWriteLock.writeLock().lock();
        reentrantReadWriteLock.writeLock().unlock();
    }
}
