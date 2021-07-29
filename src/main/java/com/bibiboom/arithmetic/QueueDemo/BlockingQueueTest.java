package com.bibiboom.arithmetic.QueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Annie
 * @date 2021年06月22日 14:16
 */
public class BlockingQueueTest {

    // 定义装苹果的篮子
    public static class Basket {
        // 篮子 , 能容纳 3 个苹果
        BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

        // 生产苹果 , 放入篮子
        public void produce() throws InterruptedException {
            // put方法放入一个苹果 , 如果basket满了 , 就等到有位置为止
            basket.put("An apple");
        }

        // 消费苹果 , 从篮子中取走
        public String consume() throws InterruptedException {
            // get方法取出一个苹果 , 如果basket为空 , 就等到有苹果为止
            String apple = basket.take();
            return apple;
        }

        // 获取篮子里苹果的数量
        public Integer getAppleNumber() {
            return basket.size();
        }
    }

    // 测试方法
    public static void testBasket() {
        // 建立一个装苹果的篮子
        final Basket basket = new Basket();

        // 定义苹果生产者
        class Producer implements Runnable {

            @Override
            public void run() {

                try {
                    while (true) {
                        // 生产苹果
                        System.out.println("生产者准备生产苹果: " + System.currentTimeMillis());
                        basket.produce();
                        System.out.println("生产完成 , 现有苹果: " + basket.getAppleNumber() + "个");
                        // 睡300ms
                        Thread.sleep(300);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        // 定义苹果消费者
        class Consumer implements Runnable {

            @Override
            public void run() {

                try {
                    while (true) {
                        // 消费苹果
                        System.out.println("消费者准备消费苹果: " + System.currentTimeMillis());
                        basket.consume();
                        System.out.println("生产完成 , 现有苹果: " + basket.getAppleNumber() + "个");
                        // 睡100ms
                        Thread.sleep(100);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        service.submit(producer);
        service.submit(consumer);
        // 程序运行10秒后 , 所有任务停止
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service.shutdownNow();
    }

    public static void main(String[] args) {
        BlockingQueueTest.testBasket();
    }
}
