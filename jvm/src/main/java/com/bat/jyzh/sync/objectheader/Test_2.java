package com.bat.jyzh.sync.objectheader;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 演示 延迟偏向锁
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 10:39
 **/
public class Test_2 {
    public static void main(String[] args) {
        try {
            // BiasedLockingStartupDelay                 = 4000, 只有开启并且大于这个值才会是延迟偏向锁
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        /**
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           05 00 00 00 (00000101 00000000 00000000 00000000) (5)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         * */
    }
}
