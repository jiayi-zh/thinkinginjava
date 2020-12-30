package com.bat.jyzh.queue;

import com.bat.jyzh.entity.Teacher;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * {@link java.lang.ref.ReferenceQueue}
 * {@link java.lang.ref.WeakReference}
 *
 * @author ZhengYu
 * @version 1.0 2020/12/30 20:02
 **/
public class ReferenceQueueApi {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue<Teacher> referenceQueue = new ReferenceQueue<>();
        Thread thread = new Thread(() -> {
            try {
                System.out.println("Listen ...");
                Reference<? extends Teacher> reference = referenceQueue.remove();
                System.out.println("GC: " + reference);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(true);
        thread.start();

        Teacher teacher = new Teacher();
        teacher.setName("jy-zh");
        System.out.println("Teacher New: " + teacher);

        WeakReference<Teacher> weakReference = new WeakReference<>(teacher, referenceQueue);
        System.out.println("WeakReference New:" + weakReference);
        teacher = null;

        System.gc();

        Thread.sleep(3000);
    }
}
