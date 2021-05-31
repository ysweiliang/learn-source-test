package cn.yuans.test.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * （JAVA）有 3 个独立的线程，一个只会输出 A，一个只会输出 L，
 * 一个只会输出 I。在三个线程同时启动的情况下，请用合理的方式让他们按顺序打印 ALIALI。
 * 三个线程开始正常输出后，主线程若检测到用户任意的输入则停止三个打印线程的工作，整体退出。
 *
 * @author yuans
 * @create 2021-04-28-0:35
 */
public class ALI {

    private volatile int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionL = lock.newCondition();
    private final Condition conditionI = lock.newCondition();

    public static void main(String[] args) {
        ALI ali = new ALI();
        Thread A = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                ali.printA();
            }
        });
        A.setName("A");
        Thread L = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                ali.printL();
            }
        });
        L.setName("L");
        Thread I = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                ali.printI();
            }
        });
        I.setName("I");

        A.start();
        L.start();
        I.start();
    }

    void printA() {
        try {
            lock.lock();
            if (flag != 1) {
                conditionA.await();
            }
            System.out.print(Thread.currentThread().getName());
            flag = 2;
            conditionL.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printL() {
        try {
            lock.lock();
            if (flag != 2) {
                conditionL.await();
            }
            System.out.print(Thread.currentThread().getName());
            flag = 3;
            conditionI.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printI() {
        try {
            lock.lock();
            if (flag != 3) {
                conditionI.await();
            }
            System.out.print(Thread.currentThread().getName());
            flag = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
