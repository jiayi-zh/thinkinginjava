package com.bat.jyzh.classloader.spi;

import com.bat.jyzh.classloader.spi.interfaces.Animal;

import java.util.ServiceLoader;

/**
 * SPI 测试
 *
 * @author ZhengYu
 * @version 1.0 2021/2/8 9:39
 **/
public class ServiceProviderInterfaceApi {
    public static void main(String[] args) {
        ServiceLoader<Animal> services = ServiceLoader.load(Animal.class);
        services.forEach(Animal::speak);
    }
}