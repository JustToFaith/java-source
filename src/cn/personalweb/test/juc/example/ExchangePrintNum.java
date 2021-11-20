package cn.personalweb.test.juc.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: JavaSourceLearn
 * @description: 多线程交换打印 1 到 100
 * @author: lizheng
 * @create: 2021-03-09 19:33
 **/
public class ExchangePrintNum {
    public static int i = 0;
    public static void main(String[] args) {
        method1();
    }


    public static void method1() {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

            Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i <= 100) {
                        System.out.println("thread1:" + i++);
                    }
                    condition.signalAll();
                    condition.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    while (i <= 100) {
                        System.out.println("thread2:" + i++);
                    }
                    condition.signalAll();
                    condition.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        thread2.start();
        thread1.start();

    }
}
