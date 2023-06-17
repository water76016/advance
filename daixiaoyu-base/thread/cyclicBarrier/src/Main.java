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
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++){
            CyclicBarrierRunnable runnable = new CyclicBarrierRunnable(cyclicBarrier, i);
            new Thread(runnable).start();
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
