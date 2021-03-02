package com.bat.jyzh.cas;

import java.util.concurrent.atomic.LongAdder;

/**
 * {@link java.util.concurrent.atomic.LongAdder} 原理剖析
 *
 * @author ZhengYu
 * @version 1.0 2021/3/1 17:39
 **/
public class LongAdderApi {
    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();

        longAdder.add(1L);
        longAdder.add(2L);
        longAdder.add(3L);

        long sum = longAdder.sum();
        System.out.println(sum);
    }
}
