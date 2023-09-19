import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-17 15:26
 **/
public class Main {
    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        //获取参与方的总数
        System.out.println("参与方的总数为：" + cyclicBarrier.getParties());
        //获取此时等待的线程数
        System.out.println("此时等待的线程数为：" + cyclicBarrier.getNumberWaiting());

        for (int i = 0; i < 10; i++){
            CyclicBarrierRunnable runnable = new CyclicBarrierRunnable(cyclicBarrier, i);
            new Thread(runnable).start();
        }
    }
}
