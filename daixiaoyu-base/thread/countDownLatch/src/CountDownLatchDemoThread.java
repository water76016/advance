import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-06-15 23:29
 **/
public class CountDownLatchDemoThread implements Runnable{
    private CountDownLatch latch;
    private int number;

    public CountDownLatchDemoThread(CountDownLatch latch, int number) {
        this.latch = latch;
        this.number = number;
    }

    @Override
    public void run() {
        try {
            //登山需要花费3秒，因此休眠3秒
            TimeUnit.SECONDS.sleep(3);
            System.out.println(number + "号选手成功登山");
            latch.countDown();
            latch.await();
            System.out.println(number + "号选手成功下山");
        } catch (Exception e) {
            System.out.println(number + "号选手登山失败");
        }
    }
}
