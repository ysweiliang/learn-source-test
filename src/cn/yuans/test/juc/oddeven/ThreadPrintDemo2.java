package cn.yuans.test.juc.oddeven;


/**
 * volatile
 *
 * @author yuans
 * @create 2021-04-27-23:19
 */
public class ThreadPrintDemo2 {

    static volatile int num = 1;
    //flag为false则打印奇数，否则打印偶数
    static volatile boolean flag = false;

    public static void main(String[] args) {
        //打印偶数
        Thread t1 = new Thread(() -> {
            while (5 > num) {
                if (flag && num % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + num);
                    num++;
                    flag = false;
                }
            }
        }, "打印偶数");
        //打印奇数
        Thread t2 = new Thread(() -> {
            while (5 > num) {
                if (!flag && num % 2 == 1) {
                    System.out.println(Thread.currentThread().getName() + num);
                    num++;
                    flag = true;
                }
            }
        }, "打印奇数");

        t1.start();
        t2.start();
    }
}
