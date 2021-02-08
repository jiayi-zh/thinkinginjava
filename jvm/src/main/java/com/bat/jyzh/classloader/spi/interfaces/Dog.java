package com.bat.jyzh.classloader.spi.interfaces;

/**
 * Dog
 *
 * @author ZhengYu
 * @version 1.0 2021/2/8 9:41
 **/
public class Dog implements Animal {

    @Override
    public void speak() {
        System.out.println("汪汪");
    }
}
