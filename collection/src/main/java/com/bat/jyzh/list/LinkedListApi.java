package com.bat.jyzh.list;

import java.util.LinkedList;

/**
 * {@link java.util.LinkedList}
 *
 * @author ZhengYu
 * @version 1.0 2021/1/14 15:00
 **/
public class LinkedListApi {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();

        // 增
        linkedList.add("str1");
        linkedList.add(1, "str2");
        linkedList.addFirst("str0");
        linkedList.addLast("str4");

        linkedList.offer("str5");


        // 获取首元素
        String first1 = linkedList.peek();
        String first2 = linkedList.poll();
        assert first1 != null;
        System.out.println(first1.equals(first2));

        linkedList.removeLastOccurrence("str5");

        linkedList.set(0, "str0_0");


        String s2 = linkedList.get(2);
        System.out.println(s2);
    }
}
