package com.bat.jyzh.sync;

/**
 * synchronized 关键字的用法
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 10:00
 **/
public class SynchronizedUse {

    private static final Object obj = new Object();

    public static void main(String[] args) {

    }

    // 1.static -> lock SynchronizedUse.class obj
    public static synchronized void method1() {

    }

    // 2.method -> lock SynchronizedUse instance obj -> method2 Access flags: add synchronized
    public synchronized void method2() {

    }

    public void method3() {
        // 3.code block -> lock obj -> decompile: monitor enter(1) / monitor exist(2)
        synchronized (obj) {

        }
    }

}