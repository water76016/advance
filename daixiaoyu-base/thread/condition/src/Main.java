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
    private final Lock lock = new ReentrantLock();
    //定义属于这个锁的条件变量
    private final Condition condition = lock.newCondition();
    //定义一个标志位
    private boolean flag = false;

    public void printNum(){
        lock.lock();
        try {
            if (!flag){
                System.out.println("flag此时为false，先等等...");
                condition.await();
            }
            System.out.println("flag此时为true");
        }
        catch (Exception e){
            System.out.println("等待出现异常");
        }
        finally {
            lock.unlock();
        }
    }

    public void addNum(){
        lock.lock();
        try {
            flag = true;
            System.out.println("flag为true了，进行唤醒");
            condition.signalAll();
        }
        catch (Exception e){
            System.out.println("累加出现异常");
        }
        finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //休眠5秒后执行
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.addNum();
            }
        });
        thread.start();
        main.printNum();

        System.out.println("程序结束");
    }
}
