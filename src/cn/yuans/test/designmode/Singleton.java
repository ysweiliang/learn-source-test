package cn.yuans.test.designmode;

/**
 * 单例模式
 *
 * @author yuans
 * @create 2020-10-14-23:45
 */
public class Singleton {

    //volatile防止指令重排导致实例化问题
    private volatile static Singleton uniqueInstance;

    public Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            //临界区锁唯一
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    //1.分配内存空间；2.初始化instance；3.instance指向分配的内存空间
                    //volatile防止指令重排，线程t1执行1,3两步骤还未生成实例，线程t2发现instance不为空就直接返回instance
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
