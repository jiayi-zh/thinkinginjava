package com.bat.jyzh.threadqueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * {@link java.util.concurrent.BlockingQueue}
 * {@link java.util.concurrent.LinkedBlockingQueue}
 * {@link java.util.concurrent.ArrayBlockingQueue}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/25 11:09
 **/
public class BlockingQueueApi {
    public static void main(String[] args) {

    }

    /**
     * java.util.concurrent.LinkedBlockingQueue}
     *
     * @author ZhengYu
     */
    private static void testLinkedBlockingQueue() throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>(1);
        linkedBlockingQueue.put("str1");
        String take = linkedBlockingQueue.take();
        System.out.println(take);
    }

    /**
     * java.util.concurrent.ArrayBlockingQueue}
     *
     * @author ZhengYu
     */
    private static void testArrayBlockingQueue() throws InterruptedException {
        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        arrayBlockingQueue.put("str1");
        String take = arrayBlockingQueue.take();
        System.out.println(take);
    }
}
