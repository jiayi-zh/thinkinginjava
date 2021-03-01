package com.bat.jyzh.designpatterns.proxy.dynamic;

import com.bat.jyzh.designpatterns.proxy.dynamic.support.CustomService;
import com.bat.jyzh.designpatterns.proxy.dynamic.support.CustomServiceImpl;

import java.lang.reflect.Proxy;

/**
 * JDK 动态代理客户端
 *
 * @author ZhengYu
 * @version 1.0 2021/3/1 13:20
 **/
public class JDKDynamicProxyMain {
    public static void main(String[] args) {
        CustomService customService = ((CustomService) Proxy.newProxyInstance(
                JDKDynamicProxyMain.class.getClassLoader(),
                new Class[]{CustomService.class},
                new CustomServiceInvocationHandler(new CustomServiceImpl())));
        customService.speak();
    }
}
