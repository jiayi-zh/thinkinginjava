package com.bat.jyzh.entity;

import java.util.List;

/**
 * Student
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 12:37
 **/
public class Student implements Person {

    private Long id;

    private String name;

    private Integer age;

    private List<Teacher> teacherList;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @Override
    public String selfIntroduce() {
        return String.format("[student] my name is: %s", name);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
