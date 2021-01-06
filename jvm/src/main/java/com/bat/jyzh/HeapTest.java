package com.bat.jyzh;

import com.bat.jyzh.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

/**
 * 模拟 OOM
 *
 * @author ZhengYu
 * @version 1.0 2021/1/5 10:50
 **/
public class HeapTest {

    private static final LongAdder IdAutoIncr = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        List<User> list = new ArrayList<>();
        do {
            User user = new User();
            IdAutoIncr.increment();
            user.setId(IdAutoIncr.longValue());
            list.add(user);
            Thread.sleep(10);
        } while (true);
    }
}
