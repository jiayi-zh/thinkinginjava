package com.bat.jyzh.sync.objectheader;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 演示 延迟偏向锁 -> 偏向锁
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 10:39
 **/
public class Test_5 {
    public static void main(String[] args) {
        try {
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
         *       8     4        (object header)                           28 0f 00 00 (00101000 00001111 00000000 00000000) (3880)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         * */

        synchronized (obj) {
            // System.out.println(obj.hashCode());


            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            /**
             * java.lang.Object object internals:
             *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
             *       0     4        (object header)                           05 11 02 a3 (00000101 00010001 00000010 10100011) (-1560145659)
             *       4     4        (object header)                           46 01 00 00 (01000110 00000001 00000000 00000000) (326)
             *       8     4        (object header)                           28 0f 00 00 (00101000 00001111 00000000 00000000) (3880)
             *      12     4        (loss due to the next object alignment)
             * Instance size: 16 bytes
             * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
             * */
        }
    }
}
