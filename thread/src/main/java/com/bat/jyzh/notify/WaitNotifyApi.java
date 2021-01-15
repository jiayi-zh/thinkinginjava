package com.bat.jyzh.notify;

import java.util.concurrent.TimeUnit;

/**
 * 必须从同步环境内调用 {@link Object#wait()} {@link Object#notify()} 方法
 *
 * @author ZhengYu
 * @version 1.0 2021/1/15 15:06
 **/
public class WaitNotifyApi {

    private static final Object OBJ = new Object();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (OBJ) {
                    System.out.printf("thread: %s wait... %n", Thread.currentThread().getName());
                    try {
                        OBJ.wait(); // 执行wait()的线程立即放弃它在对象上的锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("thread: %s notify... %n", Thread.currentThread().getName());
                }
            }).start();
        }

        TimeUnit.SECONDS.sleep(1);
        synchronized (OBJ) {
            OBJ.notify(); // 调用notify()时，并不意味着这时线程会放弃其锁。如果线程仍然在完成同步代码，则线程在移出之前不会放弃锁。因此，只要调用notify()并不意味着这时该锁变得可用
        }

        TimeUnit.SECONDS.sleep(3);
        synchronized (OBJ) {
            OBJ.notifyAll();
        }
    }
}
