package com.bat.jyzh.aqs;

import java.util.concurrent.Phaser;

/**
 * {@link java.util.concurrent.Phaser}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/3 15:07
 **/
public class PhaserApi {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);
        System.out.println(Integer.toBinaryString(65537));

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                phaser.awaitAdvance(phaser.getPhase());
                System.out.println(Thread.currentThread().getName() + "执行任务完成，等待其他任务执行......");
                //等待其他任务执行完成
                phaser.arriveAndAwaitAdvance();
                System.out.println(Thread.currentThread().getName() + "继续执行任务...");
            }).start();
        }

        phaser.arrive();
    }
}
