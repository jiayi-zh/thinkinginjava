package com.bat.jyzh.set;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * {@link java.util.concurrent.CopyOnWriteArraySet}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 21:54
 **/
public class CopyOnWriteArraySetApi {
    public static void main(String[] args) {
        CopyOnWriteArraySet<String> copyOnWriteArraySet = new CopyOnWriteArraySet<>();

        copyOnWriteArraySet.add("str1");

        System.out.println(copyOnWriteArraySet);
    }
}
