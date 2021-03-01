package com.bat.jyzh.designpatterns.proxy.dynamic.support;

/**
 * Custom Service Impl
 *
 * @author ZhengYu
 * @version 1.0 2021/3/1 13:24
 **/
public class CustomServiceImpl implements CustomService {

    @Override
    public void speak() {
        System.out.println("被代理对象的实现 ...");
    }
}
