package com.bat.jyzh.sync.objectheader;

import org.openjdk.jol.info.ClassLayout;

/**
 * 演示 无锁 -> 轻量级锁
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 10:39
 **/
public class Test_3 {
    public static void main(String[] args) {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        /**
         * java.lang.Object object internals:
         *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
         *       0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
         *      12     4        (loss due to the next object alignment)
         * Instance size: 16 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         * */

        // System.out.println(obj.hashCode());

        synchronized (obj) {

            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            /**
             * java.lang.Object object internals:
             *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
             *       0     4        (object header)                           f8 f4 df 33 (11111000 11110100 11011111 00110011) (870315256)
             *       4     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
             *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
             *      12     4        (loss due to the next object alignment)
             * Instance size: 16 bytes
             * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
             * */
        }
    }
}
