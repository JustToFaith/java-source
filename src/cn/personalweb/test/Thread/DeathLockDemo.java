package cn.personalweb.test.Thread;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2020-12-13 15:58
 **/
public class DeathLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程 1").start();
        // 构成死锁
//        new Thread(() -> {
//            synchronized (resource2) {
//                System.out.println(Thread.currentThread() + "get resource2");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println(Thread.currentThread() + "waiting resource1");
//                synchronized (resource1) {
//                    System.out.println(Thread.currentThread() + "get resource 1");
//                }
//            }
//        }, "线程 2").start();


        // 改成这样就不会有死锁了.
        new Thread(() -> {
            // 先获取资源 1 , 如果资源 1 已经被其他现在占用,就不会进去
            synchronized (resource1) {
                // 进来后就说明资源 1 已经没有线程占用了
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread() + "waiting resource1");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource 1");
                }
            }
        }, "线程 2").start();



    }
}
