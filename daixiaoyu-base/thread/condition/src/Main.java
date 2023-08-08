import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: advance
 * @author: water76016
 * @description:
 * @version: v1.0.0
 * @create: 2023-07-29 01:11
 **/
public class Main {
    //定义一个锁
    public static final Lock reentrantLock = new ReentrantLock();
    //定义属于这个锁的条件变量
    public static final Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) {
        //先启动一下线程
        Thread thread = new Thread(new OtherThread());
        thread.start();

        //先加锁
        reentrantLock.lock();
        try {
            System.out.println("线程加锁成功，正在执行相关代码");
            while (!GlobalSymbol.globalFlag.get()){
                System.out.println("现在条件还不满足，先等待");
                condition.await();
            }
            System.out.println("线程被唤醒，执行后续代码");
        }
        catch (Exception e){
            System.out.println("加锁解锁逻辑出现异常");
        }
        finally {
            //在finally中释放锁
            reentrantLock.unlock();
        }
        System.out.println("程序结束");
    }
}
