package com.bibiboom.arithmetic;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Annie
 * @date 2021年05月29日 16:24
 */
public class JUC implements Runnable{

    private Lock lock = new ReentrantLock();// 创建Lock锁
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            lock.lock(); // 上锁
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "完成售票，余票为：" + (--ticket));
                }
            } finally {
                lock.unlock(); // 释放锁
            }
        }
    }


}

