import com.sun.corba.se.impl.encoding.CDROutputObject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-09-17 13:08
 **/
public class MaiCaiThread implements Runnable{
    private CountDownLatch countDownLatch;
    public MaiCaiThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("出门买菜回来了");
        countDownLatch.countDown();
    }
}
