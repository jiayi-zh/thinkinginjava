package com.bat.jyzh.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPool {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("Hello Schedule"), 1, 2, TimeUnit.SECONDS);

        Thread.sleep(5000);
        scheduledFuture.cancel(true);
    }
}