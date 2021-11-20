package cn.personalweb.test.juc.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2021-03-31 21:16
 **/
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(50, 80, 30, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
