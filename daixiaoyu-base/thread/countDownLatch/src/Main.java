import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-15 23:26
 **/
public class Main {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(4);
        System.out.println("选手开始登山");
        for (int i = 0; i < 4; i++) {
            final int a = i;
            Runnable runnable = new CountDownLatchDemoThread(latch, i);
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}
