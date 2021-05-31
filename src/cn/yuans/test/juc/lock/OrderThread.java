package cn.yuans.test.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuans
 * @create 2021-04-27-16:53
 */
public class OrderThread {

    private volatile int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        OrderThread orderThread = new OrderThread();
        Thread A = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                orderThread.printA();
            }
        });
        A.setName("A");
        Thread B = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                orderThread.printB();
            }
        });
        B.setName("B");
        Thread C = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                orderThread.printC();
            }
        });
        C.setName("C");

        A.start();
        B.start();
        C.start();
    }

    public void printA() {
        try {
            lock.lock();
            if (flag != 1) {
                try {
                    conditionA.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            flag = 2;
            conditionB.signal();
        } finally {
            lock.unlock();
        }

    }

    public void printB() {
        try {
            lock.lock();
            if (flag != 2) {
                try {
                    conditionB.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            flag = 3;
            conditionC.signal();
        } finally {
            lock.unlock();
        }

    }

    public void printC() {
        try {
            lock.lock();
            if (flag != 3) {
                try {
                    conditionC.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            flag = 1;
            conditionA.signal();
        } finally {
            lock.unlock();
        }
    }
}
