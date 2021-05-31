package cn.yuans.test.juc.oddeven;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * condition
 *
 * @author yuans
 * @create 2021-04-27-23:54
 */
public class ThreadPrintDemo4 {
    static volatile int num = 1;
    private final Lock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();
    static int limit = 4;

    public static void main(String[] args) {
        ThreadPrintDemo4 threadPrintDemo4 = new ThreadPrintDemo4();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < limit / 2; i++) {
                threadPrintDemo4.printOdd();
            }
        }, "打印奇数");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < limit / 2; i++) {
                threadPrintDemo4.printEven();
            }
        }, "打印偶数");

        t1.start();
        t2.start();
    }

    public void printOdd() {
        try {
            lock.lock();
            if (num % 2 == 0) {
                evenCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + num);
            num++;
            oddCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printEven() {
        try {
            lock.lock();
            if (num % 2 == 1) {
                oddCondition.await();
            }
            System.out.println(Thread.currentThread().getName() + num);
            num++;
            evenCondition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
