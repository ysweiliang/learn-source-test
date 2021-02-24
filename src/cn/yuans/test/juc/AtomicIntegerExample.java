package cn.yuans.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类测试
 *
 * @author yuans
 * @create 2021-01-04-22:01
 */
public class AtomicIntegerExample {

    static int c = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        for (int i = 0; i < 100; i++) {
                            c++;
                            atomicInteger.incrementAndGet();
                        }
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 等待所有线程完成累加操作后再输出最后的值
        latch.await();
        System.err.println(atomicInteger.get());
        System.err.println(c);
        newFixedThreadPool.shutdown();
    }
}
