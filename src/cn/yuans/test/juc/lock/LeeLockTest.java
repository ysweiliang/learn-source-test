package cn.yuans.test.juc.lock;

/**
 * @author yuans
 * @create 2021-04-22-11:36
 */
public class LeeLockTest {
    static int count = 0;
    static LeeLock leeLock = new LeeLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            try {
                leeLock.lock();
                for (int i = 0; i < 10000; i++) {
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                leeLock.unlock();
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(count);
    }
}
