package com.bat.jyzh.memory;

import org.openjdk.jol.info.ClassLayout;

/**
 * 指针压缩 [-XX:[+|-]UseCompressedOops]
 * 开启指针压缩, 对象头中 类型指针
 *
 * @author ZhengYu
 * @version 1.0 2021/1/11 9:41
 **/
public class PointerCompressionTest {

    private static final int[] ARR = new int[]{1, 2, 3};

    private static final NorMalClass NORMAL_CLASS = new NorMalClass();

    public static void main(String[] args) {

        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        System.out.println(ClassLayout.parseInstance(NORMAL_CLASS).toPrintable());

        System.out.println(ClassLayout.parseInstance(ARR).toPrintable());
    }

    private static class NorMalClass {
        int a = 1;
        int b = 2;
        double c = 3;
    }
}

