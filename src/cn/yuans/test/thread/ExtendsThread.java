package cn.yuans.test.thread;

/**
 * 继承实现thread
 *
 * @author yuans
 * @create 2020-06-18-15:16
 */
public class ExtendsThread extends Thread {

    @Override
    public void run() {
        System.out.println("用Thread类实现线程");
    }
}
