import java.util.concurrent.TimeUnit;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-08-09 00:19
 **/
public class OtherThread implements Runnable{
    @Override
    public void run() {
        try {
            for (int i = 10; i > 0; i--){
                System.out.println("标志位将在" + i + "秒后置为true");
                TimeUnit.SECONDS.sleep(1);
            }
            GlobalSymbol.globalFlag.set(true);
            //对被阻塞的线程进行唤醒（必须获得对应的锁后，才能执行唤醒的操作）
            Main.reentrantLock.lock();
            Main.condition.signalAll();
            Main.reentrantLock.unlock();
        }
        catch (Exception e){
            System.out.println("线程执行失败");
        }
    }
}
