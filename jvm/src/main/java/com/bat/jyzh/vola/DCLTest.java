package com.bat.jyzh.vola;

/**
 * volatile 关键字
 *
 * @author ZhengYu
 * @version 1.0 2021/1/7 10:39
 **/
public class DCLTest {

    public static volatile DCLTest instance;

    public int a = 11;

    private DCLTest() {
        a++;
    }

    public static DCLTest getInstance() {
        if (instance == null) {
            synchronized (DCLTest.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    /**
                     * 31 new #4 <com/bat/jyzh/vola/DCLTest>
                     *    1. 在堆区生成一个不完全对象(未执行构造方法)
                     *    2. 将不完全对象的指针压入操作数栈
                     * 34 dup
                     *    1. 复制栈顶元素(创建的不完全对象)
                     *    2. 将其再次压入栈(用于给this指针赋值)
                     *
                     * 35 invokespecial #10 <com/bat/jyzh/vola/DCLTest.<init>>
                     *    1. 构建方法的运行环境(创建栈帧、保存现场、给this指针赋值)
                     *    2. 调用构造方法
                     *
                     * 38 putstatic #3 <com/bat/jyzh/vola/DCLTest.instance>
                     *    1. 取出栈顶元素
                     *    2. 给变量赋值
                     */
                    instance = new DCLTest();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {

    }
}