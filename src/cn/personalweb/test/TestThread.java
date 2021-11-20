package cn.personalweb.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: JavaSourceLearn
 * @description:
 * @author: lizheng
 * @create: 2020-12-09 12:53
 **/
public class TestThread {
    public static void main(String[] args) {
//        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(12, 15,122, TimeUnit.MILLISECONDS);
        Throwable throwable = new Throwable();
//        throwable.
        System.out.println(throwable.getMessage());
        System.out.println(throwable.toString());
        throwable.printStackTrace();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 10, TimeUnit.HOURS, new ArrayBlockingQueue<>(100));
//        threadPoolExecutor.submit()
    }

}
