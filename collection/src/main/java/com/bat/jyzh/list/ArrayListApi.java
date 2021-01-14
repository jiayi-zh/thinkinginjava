package com.bat.jyzh.list;

import java.util.ArrayList;

/**
 * {@link java.util.ArrayList}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/14 14:45
 **/
public class ArrayListApi {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(1);

        arrayList.add("str1");

        arrayList.set(0, "str2");

        arrayList.remove("str1");

        System.out.println(arrayList.get(0));
    }
}
