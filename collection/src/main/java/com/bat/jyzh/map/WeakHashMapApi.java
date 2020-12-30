package com.bat.jyzh.map;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * {@link java.util.WeakHashMap}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 17:54
 **/
public class WeakHashMapApi {
    public static void main(String[] args) {
        Map<String, Integer> map = new WeakHashMap<>(3);

        map.put(new String("1"), 1);
        map.put(new String("2"), 2);
        map.put(new String("3"), 3);

        map.put("6", 6);

        String key = null;
        for (String s : map.keySet()) {
            if (s.equals("3")) {
                key = s;
            }
        }

        System.out.println(map);

        System.gc();

        map.put(new String("4"), 4);

        System.out.println(map);

        key = null;

        System.gc();

        System.out.println(map);
    }
}
