package cn.yuans.test.thread;

/**
 * Runnable接口实现thread
 *
 * @author yuans
 * @create 2020-06-18-15:14
 */
public class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("用实现Runnable接口实现线程");
    }
}
