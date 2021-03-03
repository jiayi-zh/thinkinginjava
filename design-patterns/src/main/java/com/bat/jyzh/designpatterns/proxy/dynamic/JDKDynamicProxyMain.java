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
        /*将创建的类文件保存到本地, 文件所在路径: ${Working Dictionary}/com/sun.proxy*/
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CustomService customService = ((CustomService) Proxy.newProxyInstance(
                JDKDynamicProxyMain.class.getClassLoader(),
                new Class[]{CustomService.class},
                new CustomServiceInvocationHandler(new CustomServiceImpl())));
        customService.speak();
        customService.talk();
        /**
         * PrintOut:
         *     proxy invoke before ...
         *     被代理对象的真正实现 ...
         *     proxy invoke after ...
         *     proxy invoke before ...
         *     JDK1.8 default 方法
         *     proxy invoke after ...
         * */
    }
}

/**
 * 动态代理生成对象的Class反编译结果：
 *
 * package com.sun.proxy;
 *
 * import com.bat.jyzh.designpatterns.proxy.dynamic.support.CustomService;
 * import java.lang.reflect.InvocationHandler;
 * import java.lang.reflect.Method;
 * import java.lang.reflect.Proxy;
 * import java.lang.reflect.UndeclaredThrowableException;
 *
 * public final class $Proxy0 extends Proxy implements CustomService {
 *     private static Method m1;
 *     private static Method m2;
 *     private static Method m4;
 *     private static Method m3;
 *     private static Method m0;
 *
 *     public $Proxy0(InvocationHandler var1) throws  {
 *         super(var1);
 *     }
 *
 *     public final boolean equals(Object var1) throws  {
 *         try {
 *             return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
 *         } catch (RuntimeException | Error var3) {
 *             throw var3;
 *         } catch (Throwable var4) {
 *             throw new UndeclaredThrowableException(var4);
 *         }
 *     }
 *
 *     public final String toString() throws  {
 *         try {
 *             return (String)super.h.invoke(this, m2, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     public final void talk() throws  {
 *         try {
 *             super.h.invoke(this, m4, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     public final void speak() throws  {
 *         try {
 *             super.h.invoke(this, m3, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     public final int hashCode() throws  {
 *         try {
 *             return (Integer)super.h.invoke(this, m0, (Object[])null);
 *         } catch (RuntimeException | Error var2) {
 *             throw var2;
 *         } catch (Throwable var3) {
 *             throw new UndeclaredThrowableException(var3);
 *         }
 *     }
 *
 *     static {
 *         try {
 *             m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
 *             m2 = Class.forName("java.lang.Object").getMethod("toString");
 *             m4 = Class.forName("com.bat.jyzh.designpatterns.proxy.dynamic.support.CustomService").getMethod("talk");
 *             m3 = Class.forName("com.bat.jyzh.designpatterns.proxy.dynamic.support.CustomService").getMethod("speak");
 *             m0 = Class.forName("java.lang.Object").getMethod("hashCode");
 *         } catch (NoSuchMethodException var2) {
 *             throw new NoSuchMethodError(var2.getMessage());
 *         } catch (ClassNotFoundException var3) {
 *             throw new NoClassDefFoundError(var3.getMessage());
 *         }
 *     }
 * }
 * */