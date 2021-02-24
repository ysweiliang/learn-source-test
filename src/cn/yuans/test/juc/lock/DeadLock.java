package cn.yuans.test.juc.lock;

/**
 * @author yuans
 * @create 2020-10-13-10:49
 */
public class DeadLock implements Runnable {
    private int flag = 1;
    private static final Object o1 = new Object();
    private static final Object o2 = new Object();

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        if (flag == 1) {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName() + " o1");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println(Thread.currentThread().getName() + " o2");
                }
            }
        }
        if (flag == 2) {
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName() + " o2");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println(Thread.currentThread().getName() + " o1");
                }
            }
        }
    }

    /**
     * o1、o2是static类型属于整个类，所以当定义deadLock1、deadLock2时是公用o1、o2的
     * deadLock1设置flag=1，先锁住o1，然后睡800ms，此时
     * deadLock2设置flag=2，先锁住o2，然后睡800ms
     * 然后deadLock1开始锁o2,不过o2还被deadLock2锁着，只好等待。。。
     * 此时deadLock1开始锁01，不过o1还被deadLock1锁着，只好等待。。。
     */
    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();

        deadLock1.setFlag(1);
        Thread thread1 = new Thread(deadLock1, "Thread1");
        thread1.start();

        deadLock2.setFlag(2);
        Thread thread2 = new Thread(deadLock2, "Thread2");
        thread2.start();
    }
}
