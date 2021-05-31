package cn.yuans.test.juc.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author yuans
 * @create 2021-04-22-11:33
 */
public class LeeLock {

    private static class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
            return compareAndSetState(0, 1);
        }

        @Override
        protected boolean tryRelease(int arg) {
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private final Sync sync = new Sync();

    public void lock() {
        sync.acquire(1);
    }

    public void unlock() {
        sync.release(1);
    }
}
