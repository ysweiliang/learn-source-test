package cn.yuans.test.juc.oddeven;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * cas
 *
 * @author yuans
 * @create 2021-04-27-23:03
 */
public class ThreadPrintDemo {

    static AtomicInteger num = new AtomicInteger(1);
    //flag为false则打印奇数，否则打印偶数
    static volatile boolean flag = false;

    static int limit = 5;

    public static void main(String[] args) {
        //打印偶数
        Thread t1 = new Thread(() -> {
            while (limit > num.get()) {
                if (flag && num.get() % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + num.get());
                    num.getAndIncrement();
                    flag = false;
                }
            }
        }, "打印偶数");
        //打印奇数
        Thread t2 = new Thread(() -> {
            while (limit > num.get()) {
                if (!flag && num.get() % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + num.get());
                    num.getAndIncrement();
                    flag = true;
                }
            }
        }, "打印奇数");

        t1.start();
        t2.start();
    }
}
