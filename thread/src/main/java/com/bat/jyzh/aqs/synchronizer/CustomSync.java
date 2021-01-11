package com.bat.jyzh.aqs.synchronizer;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自定义 {@link java.util.concurrent.locks.AbstractQueuedSynchronizer 实现 }
 *
 * @author ZhengYu
 * @version 1.0 2021/1/8 11:33
 **/
public class CustomSync extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        return super.tryAcquire(arg);
    }


    @Override
    protected boolean tryRelease(int arg) {
        return super.tryRelease(arg);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return super.tryAcquireShared(arg);
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        return super.tryReleaseShared(arg);
    }

    @Override
    protected boolean isHeldExclusively() {
        return super.isHeldExclusively();
    }
}
