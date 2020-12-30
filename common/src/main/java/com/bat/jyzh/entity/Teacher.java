package com.bat.jyzh.entity;

import java.util.List;

/**
 * Teacher
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 12:37
 **/
public class Teacher implements Person {

    private Long id;

    private String name;

    private String age;

    private List<Student> studentList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String selfIntroduce() {
        return String.format("[teacher] my name is: %s", name);
    }
}
