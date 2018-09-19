package com.zhangzhen.case01;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangzhen
 * @since 2018-09-18
 */
public class SingletonTest {

    /**
     * 测试 Singleton 单例的线程安全性
     *
     * @throws InterruptedException
     */
    @Test
    public void testSingleton() throws InterruptedException {
        final int totalThread = 500;
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 利用 HashSet 去重
        Set<Integer> set = new HashSet<>();
        Collection<Integer> synSet = Collections.synchronizedCollection(set);
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(
                () -> {
                    synSet.add(Singleton.getInstance().hashCode());
                    System.out.println("put the singleton instance's hashCode into the hashSet...");
                    countDownLatch.countDown();
                });
        }
        countDownLatch.await();
        System.out.println("all thread finished...");
        executorService.shutdown();
        Assert.assertEquals(
            "the hashSet's size: " + synSet.size() + ", the only value is: " + synSet.iterator().next(),
            1,
            synSet.size());
    }
}
