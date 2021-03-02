package com.bat.jyzh.designpatterns.proxy.dynamic.support;

/**
 * Custom Service
 *
 * @author ZhengYu
 * @version 1.0 2021/3/1 13:21
 **/
public interface CustomService {

    void speak();

    default void talk() {
        System.out.println("JDK1.8 default 方法");
    }
}
