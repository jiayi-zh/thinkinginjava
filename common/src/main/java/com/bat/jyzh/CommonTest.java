package com.bat.jyzh;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 临时测试专用
 *
 * @author ZhengYu
 * @version 1.0 2021/1/17 10:42
 **/
public class CommonTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {

            });
        }
    }
}
