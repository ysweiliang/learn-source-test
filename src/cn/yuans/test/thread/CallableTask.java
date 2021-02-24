package cn.yuans.test.thread;

import java.util.Random;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * 有返回值的 Callable 创建线程，Runnable 创建线程是无返回值的，而 Callable 和与之相关的 Future、FutureTask，它们可以把线程执行的结果作为返回值返回，如代码所示，实现了 Callable 接口，并且给它的泛型设置成 Integer，然后它会返回一个随机数。
 *
 * @author yuans
 * @create 2020-06-18-15:37
 */
public class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService service = newFixedThreadPool(10);
        //提交任务，并用Future提交返回结果
        Future<Integer> future = service.submit(new CallableTask());
        System.out.println(future.get());
    }
}
