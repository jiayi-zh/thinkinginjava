package com.bat.jyzh.aqs;

import java.util.concurrent.Semaphore;

/**
 * {@link java.util.concurrent.Semaphore}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/1 17:20
 **/
public class SemaphoreApi {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1, true);

        semaphore.acquire();

        semaphore.release();
    }
}
