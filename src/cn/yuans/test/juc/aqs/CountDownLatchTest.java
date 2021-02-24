package cn.yuans.test.juc.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @author yuans
 * @create 2021-02-24-15:47
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        // 这边插入一些代码，确保上面的每个线程先启动起来，才执行下面的代码。
//        System.out.println("-----------1------------");            // don't let run yet
        // 因为这里 N == 1，所以，只要调用一次，那么所有的 await 方法都可以通过
        startSignal.countDown();      // let all threads proceed
//        Thread.sleep(100);
        System.out.println("-----------2------------");
        // 等待所有任务结束
        doneSignal.await();           // wait for all to finish
    }

    static class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;

        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        public void run() {
            try {
                // 为了让所有线程同时开始任务，我们让所有线程先阻塞在这里
                // 等大家都准备好了，再打开这个门栓
                startSignal.await();
                System.out.println("-----------3------------");
                doneSignal.countDown();
            } catch (InterruptedException ex) {
            } // return;
        }
    }
}
