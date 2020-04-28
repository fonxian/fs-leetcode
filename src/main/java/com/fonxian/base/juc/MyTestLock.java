package com.fonxian.base.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Michael Fang
 * @since 2020-04-01
 */
public class MyTestLock implements Lock {

    private static volatile int i = 0;

    private  MySyn mySyn = new MySyn();

    @Override
    public void lock() {

        mySyn.acquire(1);
//        synchronized (this) {
//
//            while (i == 1) {
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            i = 1;
//        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
//        synchronized (this) {
//            this.notifyAll();
//            i = 0;
//        }
        mySyn.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    class MySyn extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (!isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }
}
