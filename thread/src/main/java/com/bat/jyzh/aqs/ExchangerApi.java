package com.bat.jyzh.aqs;

import java.util.concurrent.Exchanger;

/**
 * {@link java.util.concurrent.Exchanger}
 *
 * @author ZhengYu
 * @version 1.0 2021/2/3 17:44
 **/
public class ExchangerApi {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();

        exchanger.exchange("");
    }
}
