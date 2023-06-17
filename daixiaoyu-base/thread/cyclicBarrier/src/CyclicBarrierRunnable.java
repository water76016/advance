import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-17 15:28
 **/
public class CyclicBarrierRunnable implements Runnable{
    private CyclicBarrier cyclicBarrier;
    private int number;

    public CyclicBarrierRunnable(CyclicBarrier cyclicBarrier, int number) {
        this.cyclicBarrier = cyclicBarrier;
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("选手" + number + "成功登山");
        System.out.println("选手" + number + "等待队友");
        try {
            cyclicBarrier.await();
        } catch (Exception e) {
            System.out.println("线程执行出现问题");
        }
        System.out.println("选手" + number + "下山");
    }
}
