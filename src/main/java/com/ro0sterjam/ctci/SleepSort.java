package com.ro0sterjam.ctci;

import java.util.concurrent.CountDownLatch;

/**
 * Created by kenwang on 2016-04-19.
 */
public class SleepSort {

    public static void sort(int[] array) {
        final CountDownLatch countDownLatch = new CountDownLatch(array.length);
        for (final int i : array) {
            new Thread(() -> {
                countDownLatch.countDown();
                try {
                    countDownLatch.await();
                    Thread.sleep(i * 10);
                    System.out.println(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        sort(new int[]{ 4, 2, 6, 33, 2, 3, 6, 23, 1, 4 });
    }

}
