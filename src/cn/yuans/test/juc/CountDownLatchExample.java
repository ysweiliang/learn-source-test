package cn.yuans.test.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author yuans
 * @create 2020-12-28-10:20
 */
public class CountDownLatchExample {
    /**
     * CountDownLatch是基于AbstractQueuedSynchronizer实现的，在AbstractQueuedSynchronizer中维护了一个volatile类型的整数state，
     * volatile可以保证多线程环境下该变量的修改对每个线程都可见，并且由于该属性为整型，因而对该变量的修改也是原子的。
     * 创建一个CountDownLatch对象时，所传入的整数n就会赋值给state属性，当countDown()方法调用时，该线程就会尝试对state减一，
     * 而调用await()方法时，当前线程就会判断state属性是否为0，如果为0，则继续往下执行，如果不为0，则使当前线程进入等待状态，
     * 直到某个线程将state属性置为0，其就会唤醒在await()方法中等待的线程。
     *
     * @param args xx
     * @throws InterruptedException xx
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Service service = new Service(latch);
        Runnable task = service::exec;
        System.out.println("main thread await.");
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }
        latch.await();
        System.out.println("main thread finishes await.");
    }
}

class Service {
    private final CountDownLatch latch;

    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    public void exec() {
        try {
            System.out.println(Thread.currentThread().getName() + " execute task.");
            sleep(2);
            System.out.println(Thread.currentThread().getName() + " finished task.");
        } finally {
            latch.countDown();
        }
    }

    private void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
