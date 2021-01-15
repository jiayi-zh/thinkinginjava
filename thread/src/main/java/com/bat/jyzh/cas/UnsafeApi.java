package com.bat.jyzh.cas;

import com.bat.jyzh.entity.Student;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * {@link sun.misc.Unsafe} API
 *
 * @author ZhengYu
 * @version 1.0 2021/1/15 17:30
 **/
public class UnsafeApi {

    private static Unsafe UNSAFE = null;

    private static long STUDENT_ID_OFFSET = 0;

    static {
        try {
            Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafeInstance.setAccessible(true);
            UNSAFE = (Unsafe) theUnsafeInstance.get(Unsafe.class);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            STUDENT_ID_OFFSET = UNSAFE.objectFieldOffset(Student.class.getDeclaredField("id"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Student student = new Student();
        student.setId(1L);

        boolean andSwapInt = UNSAFE.compareAndSwapLong(student, STUDENT_ID_OFFSET, 1L, 2L);
        System.out.println(andSwapInt + " - " + student.getId());
    }
}
