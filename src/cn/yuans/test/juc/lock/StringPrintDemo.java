package cn.yuans.test.juc.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 用多线程去处理"123"，"456"，“789”这个三个字符串，然后以"147"，"258"，"369"这种形式去输出，请写出代码实现
 *
 * @author yuans
 * @create 2021-04-28-13:20
 */
public class StringPrintDemo {

    private volatile int flag = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        String a = "123";
        String b = "456";
        String c = "789";
        StringPrintDemo stringPrintDemo = new StringPrintDemo();
        Thread A = new Thread(() -> {
            for (int i = 0; i < a.toCharArray().length; i++) {
                stringPrintDemo.print(a.toCharArray()[i]);
            }
        });

        Thread B = new Thread(() -> {
            for (int i = 0; i < b.toCharArray().length; i++) {
                stringPrintDemo.print2(b.toCharArray()[i]);
            }
        });

        Thread C = new Thread(() -> {
            for (int i = 0; i < c.toCharArray().length; i++) {
                stringPrintDemo.print3(c.toCharArray()[i]);
            }
        });

        A.start();
        B.start();
        C.start();
    }

    void print(char c) {
        try {
            lock.lock();
            if (flag != 1) {
                conditionA.await();
            }
            System.out.print(c);
            flag = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print2(char c) {
        try {
            lock.lock();
            if (flag != 2) {
                conditionB.await();
            }
            System.out.print(c);
            flag = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void print3(char c) {
        try {
            lock.lock();
            if (flag != 3) {
                conditionC.await();
            }
            System.out.print(c);
            flag = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
