package cn.yuans.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.util.concurrent.Executors.*;

/**
 * 现成测试
 *
 * @author yuans
 * @create 2020-06-18-15:13
 */
public class ThreadTest {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread().start();
        }
        System.out.println("aaaa");
    }
}
