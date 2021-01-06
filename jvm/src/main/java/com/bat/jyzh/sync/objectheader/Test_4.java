package com.bat.jyzh.sync.objectheader;

import com.bat.jyzh.model.User;
import org.openjdk.jol.info.ClassLayout;

/**
 * 演示 无锁 -> 重量级锁
 *
 * @author ZhengYu
 * @version 1.0 2021/1/6 10:39
 **/
public class Test_4 {
    public static void main(String[] args) {
        User obj = new User();
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

        synchronized (obj) {
            // TODO 如果调用普通方法obj还是轻量级锁，但是调用 hashCode 方法会膨胀为重量级锁
            System.out.println(obj.hashCode());

            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
            /**
             * java.lang.Object object internals:
             *  OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
             *       0     4        (object header)                           4a 61 69 fb (01001010 01100001 01101001 11111011) (-76979894)
             *       4     4        (object header)                           ec 01 00 00 (11101100 00000001 00000000 00000000) (492)
             *       8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
             *      12     4        (loss due to the next object alignment)
             * Instance size: 16 bytes
             * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
             * */
        }
    }
}
