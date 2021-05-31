package cn.yuans.test.juc.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 已知一个业务查询操作涉及 3 个 RPC 服务调用 : query1, query2, query3, 其中query1 耗时约 1 秒，
 * query2 耗时约 0.5 秒，query3 耗时约 0.6 秒，且 query3 查询条件依赖 query2 的查询结果，
 * 请编写代码，使该业务查询总体耗时最小。
 *
 * @author yuans
 * @create 2021-04-28-0:49
 */
public class QueryThread {

    /*final Lock lock = new ReentrantLock();
    final Condition condition2 = lock.newCondition();
    final Condition condition3 = lock.newCondition();
    static volatile int flag = 2;*/

    public static void main(String[] args) throws InterruptedException {
        QueryThread queryThread = new QueryThread();
        CountDownLatch count = new CountDownLatch(2);
        ExecutorService executorService = new ThreadPoolExecutor(2, 5, 60,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));
        long startTime = System.currentTimeMillis();   //获取开始时间
     /*   Thread t1 = new Thread(() -> {
            queryThread.query1();
            count.countDown();
        });
        Thread t2 = new Thread(() -> {
            queryThread.query2();
            count.countDown();
        });
        t1.start();
        t2.start();*/

        executorService.execute(() -> {
            queryThread.query1();
            count.countDown();
        });
        executorService.execute(() -> {
            queryThread.query2();
            count.countDown();
        });
        count.await();
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        System.out.println("---------end-------------");
    }

    void query1() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void query2() {
        try {
            Thread.sleep(500);
            query3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void query3() {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
