package com.bat.jyzh.threadqueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * {@link java.util.concurrent.BlockingDeque}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/25 11:20
 **/
public class BlockingDequeApi {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> linkedBlockingDeque = new LinkedBlockingDeque<>();

        linkedBlockingDeque.addFirst("str1");

        String first = linkedBlockingDeque.getFirst();
        System.out.println(first);
    }
}
