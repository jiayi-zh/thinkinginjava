package com.bat.jyzh.map;

import com.bat.jyzh.entity.Student;

import java.util.HashMap;

/**
 * {@link java.util.HashMap}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 11:01
 **/
public class HashMapApi {
    public static void main(String[] args) {
        // init
        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap1.put(null, "1");
        HashMap<String, String> hashMap2 = new HashMap<>(3);


        // add resize
        HashMap<Student, String> hashMap3 = new HashMap<>();
        for (int i = 0; i < 1 << 4; i++) {
            Student student = new Student();
            String name = "zy" + i;
            student.setName(name);
            hashMap3.put(student, name);
        }

        System.out.println(hashMap3);
    }
}