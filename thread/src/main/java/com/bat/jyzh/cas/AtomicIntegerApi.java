package com.bat.jyzh.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * {@link java.util.concurrent.atomic.AtomicInteger}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/4 11:07
 **/
public class AtomicIntegerApi {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        atomicInteger.incrementAndGet();
    }
}
