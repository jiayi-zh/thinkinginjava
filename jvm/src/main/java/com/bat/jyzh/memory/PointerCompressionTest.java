package com.bat.jyzh.memory;

import com.bat.jyzh.model.NorMalClass;
import org.openjdk.jol.info.ClassLayout;

/**
 * 指针压缩
 * [-XX:[+|-]UseCompressedOops] 对象指针压缩(oops: ordinary object pointer)
 * [-XX:[+|-]UseCompressedClassPointers] 类指针压缩
 *
 * @author ZhengYu
 * @version 1.0 2021/1/11 9:41
 **/
public class PointerCompressionTest {
    public static void main(String[] args) {

        // 空对象
        testEmptyObj();

        // 普通对象
        testNormalObj();

        // 数组对象
        testArrObj();
    }

    /**
     * 空对象是否开启指针压缩对比
     * <p>
     * 开启指针压缩-XX:+UseCompressedClassPointers -XX:+UseCompressedOops:
     * java.lang.Object object internals:
     * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     * 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4        (object header)                           e5 01 00 20 (11100101 00000001 00000000 00100000) (536871397)
     * 12    4        (loss due to the next object alignment)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * <p>
     * 关闭指针压缩-XX:-UseCompressedClassPointers -XX:-UseCompressedOops:
     * java.lang.Object object internals:
     * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     * 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4        (object header)                           00 1c 75 77 (00000000 00011100 01110101 01110111) (2004163584)
     * 12     4        (object header)                           1e 02 00 00 (00011110 00000010 00000000 00000000) (542)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 0 bytes external = 0 bytes total
     *
     * @author ZhengYu
     */
    private static void testEmptyObj() {
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
    }

    /**
     * 普通对象是否开启指针压缩对比
     * <p>
     * 开启指针压缩-XX:+UseCompressedClassPointers -XX:+UseCompressedOops:
     * com.bat.jyzh.model.NorMalClass object internals:
     * OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
     * 0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4                    (object header)                           43 c0 00 20 (01000011 11000000 00000000 00100000) (536920131)
     * 12     4                int NorMalClass.a                             0
     * 16     4   java.lang.String NorMalClass.s                             null
     * 20     4                    (loss due to the next object alignment)
     * Instance size: 24 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     * <p>
     * 关闭指针压缩-XX:-UseCompressedClassPointers -XX:-UseCompressedOops:
     * com.bat.jyzh.model.NorMalClass object internals:
     * OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
     * 0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4                    (object header)                           70 0a 95 e7 (01110000 00001010 10010101 11100111) (-409662864)
     * 12     4                    (object header)                           bd 01 00 00 (10111101 00000001 00000000 00000000) (445)
     * 16     4                int NorMalClass.a                             0
     * 20     4                    (alignment/padding gap)
     * 24     8   java.lang.String NorMalClass.s                             null
     * Instance size: 32 bytes
     * Space losses: 4 bytes internal + 0 bytes external = 4 bytes total
     *
     * @author ZhengYu
     */
    private static void testNormalObj() {
        NorMalClass NORMAL_CLASS = new NorMalClass();
        System.out.println(ClassLayout.parseInstance(NORMAL_CLASS).toPrintable());
    }

    /**
     * 数组对象是否开启指针压缩对比
     * <p>
     * 开启指针压缩-XX:+UseCompressedClassPointers -XX:+UseCompressedOops:
     * [I object internals:
     * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     * 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4        (object header)                           6d 01 00 20 (01101101 00000001 00000000 00100000) (536871277)
     * 12     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     * 16    12    int [I.<elements>                             N/A
     * 28     4        (loss due to the next object alignment)
     * Instance size: 32 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     *
     * <p>
     * 关闭指针压缩-XX:-UseCompressedClassPointers -XX:-UseCompressedOops:
     * [I object internals:
     * OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
     * 0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
     * 4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
     * 8     4        (object header)                           68 0b 74 95 (01101000 00001011 01110100 10010101) (-1787557016)
     * 12     4        (object header)                           56 01 00 00 (01010110 00000001 00000000 00000000) (342)
     * 16     4        (object header)                           03 00 00 00 (00000011 00000000 00000000 00000000) (3)
     * 20     4        (alignment/padding gap)
     * 24    12    int [I.<elements>                             N/A
     * 36     4        (loss due to the next object alignment)
     * Instance size: 40 bytes
     * Space losses: 4 bytes internal + 4 bytes external = 8 bytes total
     *
     * @author ZhengYu
     */
    private static void testArrObj() {
        int[] ARR = new int[]{1, 2, 3};
        System.out.println(ClassLayout.parseInstance(ARR).toPrintable());
    }
}

