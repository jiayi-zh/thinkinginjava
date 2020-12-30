package com.bat.jyzh.set;

import java.util.HashSet;

/**
 * {@link java.util.HashSet}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 21:31
 **/
public class HashSetApi {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("str1");
        hashSet.add("str2");

        boolean b = hashSet.contains("str1");
        System.out.println(b);
    }
}
