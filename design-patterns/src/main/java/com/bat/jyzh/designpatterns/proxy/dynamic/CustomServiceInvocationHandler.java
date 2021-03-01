package com.bat.jyzh.designpatterns.proxy.dynamic;

import com.bat.jyzh.designpatterns.proxy.dynamic.support.CustomService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * {@link CustomService 的 {@link java.lang.reflect.InvocationHandler} 实现
 *
 * @author ZhengYu
 * @version 1.0 2021/3/1 13:31
 **/
public class CustomServiceInvocationHandler implements InvocationHandler {

    private final CustomService customService;

    public CustomServiceInvocationHandler(CustomService customService) {
        this.customService = customService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("proxy invoke before ...");
        Object result = null;
        try {
            result = method.invoke(customService, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("proxy invoke after ...");
        return result;
    }
}
