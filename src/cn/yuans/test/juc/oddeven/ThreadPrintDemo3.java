package cn.yuans.test.juc.oddeven;

/**
 * synchronized
 *
 * @author yuans
 * @create 2021-04-27-23:27
 */
public class ThreadPrintDemo3 {

    public static void main(String[] args) throws InterruptedException {
        ThreadPrintDemo3 threadPrintDemo3 = new ThreadPrintDemo3(100, false);
        Thread t2 = new Thread(threadPrintDemo3::printEven, "打印偶数");
        Thread t1 = new Thread(threadPrintDemo3::printOdd, "打印奇数");
        t2.start();
        Thread.sleep(100);
        t1.start();
    }

    private int num = -1;
    private boolean flag;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public ThreadPrintDemo3(int num, boolean flag) {
        this.num = num;
        this.flag = flag;
    }

    //打印奇数
    public synchronized void printOdd() {
        for (int i = 1; i < num; i += 2) {
            if (flag == true) {
                try {
                    this.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + i);
            flag = true;
            notify();
        }
    }

    //打印偶数
    public synchronized void printEven() {
        for (int i = 0; i < num; i += 2) {
            if (flag != true) {
                try {
                    this.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + i);
            flag = false;
            notify();
        }
    }
}
