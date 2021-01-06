package com.bat.jyzh.task;

/**
 * @author ZhengYu
 * @version 1.0 2021/1/6 15:25
 **/
public class SleepTask implements Runnable {

    private static int counter = 0;

    private final long sleepTime;

    public SleepTask(long sleepTime) {
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Thread [%s] ---> %d %n", Thread.currentThread().getName(), counter++);
            Thread.sleep(sleepTime);
            System.out.printf("Thread [%s] ---> done %n", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
