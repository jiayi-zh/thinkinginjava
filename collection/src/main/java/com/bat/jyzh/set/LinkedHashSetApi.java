package com.bat.jyzh.set;

import java.util.LinkedHashSet;

/**
 * {@link java.util.LinkedHashSet}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 21:41
 **/
public class LinkedHashSetApi {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("str1");
        linkedHashSet.add("str2");

        System.out.println(linkedHashSet.size());
    }
}
