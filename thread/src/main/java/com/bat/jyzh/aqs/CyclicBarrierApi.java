package com.bat.jyzh.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * {@link java.util.concurrent.CyclicBarrier}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/2 14:20
 **/
public class CyclicBarrierApi {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("arrived ..."));

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " wait ...");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName() + " run ...");
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
