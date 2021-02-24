package cn.yuans.test.thread;

/**
 * @author yuans
 * @create 2020-06-28-11:19
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 1; i < 6; i++) {
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("子线程睡眠：" + i + "秒。");
            }
        });
//        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();//开启线程
        thread.join(2000);//等待子线程先执行2秒钟
        //主线程执行
        for (int i = 1; i < 4; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程睡眠：" + i + "秒。");
        }
    }
}

