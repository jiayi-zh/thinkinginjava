package com.bat.jyzh.pool;

import com.bat.jyzh.task.SleepTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * {@link java.util.concurrent.Executors} create
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 15:13
 **/
public class ThreadPoolMain {
    public static void main(String[] args) {
        tempTest();

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

        SynchronousQueue<Object> synchronousQueue = new SynchronousQueue<>();
    }

    public static void tempTest() {
//        printBinaryString(-1 << 29);
//        printBinaryString(-1 << 29 - 1);


    }

    public static void printBinaryString(int i) {
        System.out.println(Integer.toBinaryString(i));
    }
}
