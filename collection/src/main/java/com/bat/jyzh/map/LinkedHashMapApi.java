package com.bat.jyzh.map;

import com.bat.jyzh.entity.Student;

import java.util.LinkedHashMap;

/**
 * {@link java.util.LinkedHashMap}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 16:14
 **/
public class LinkedHashMapApi {
    public static void main(String[] args) {
        // init
        LinkedHashMap<String, Integer> linkedHashMap1 = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> linkedHashMap2 = new LinkedHashMap<>(16, 0.75f, true);

        // add resize
        LinkedHashMap<Student, String> linkedHashMap3 = new LinkedHashMap<>(16, 0.75f, true);
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            String name = "zy" + i;
            student.setName(name);
            linkedHashMap3.put(student, name);
        }

        linkedHashMap3.get(new Student());

        System.out.println(linkedHashMap3);
    }
}
