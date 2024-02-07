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
    static CountDownLatch countDownLatch = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        Thread maicai = new Thread(new MaiCaiThread(countDownLatch));
        maicai.start();

        Thread zuoFanThread = new Thread(new ZuoFanThread(countDownLatch));
        zuoFanThread.start();

        System.out.println("我想吃饭了，但是饭还没做好");
        countDownLatch.await();

        System.out.println("程序结束，我吃上饭了");
    }
}
