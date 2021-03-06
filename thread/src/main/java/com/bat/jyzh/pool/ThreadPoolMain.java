package com.bat.jyzh.pool;

import com.bat.jyzh.task.SleepTask;

import java.util.concurrent.*;

/**
 * {@link java.util.concurrent.Executors} create
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 15:13
 **/
public class ThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                10,
                30,
                TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 6; i++) {
            threadPoolExecutor.submit(new SleepTask(5000));
        }
    }
}
