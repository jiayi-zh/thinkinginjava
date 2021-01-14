package com.bat.jyzh.list;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * {@link java.util.concurrent.CopyOnWriteArrayList}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/14 16:06
 **/
public class CopyOnWriteArrayListApi {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> cowAl = new CopyOnWriteArrayList<>();
        CopyOnWriteArrayList<String> cowAl1 = new CopyOnWriteArrayList<>(new ArrayList<>());
        CopyOnWriteArrayList<String> cowAl2 = new CopyOnWriteArrayList<>(new String[]{});

        cowAl.add("str1");
        cowAl.addIfAbsent("str2");

        System.out.println(cowAl.size());
    }
}
