package com.bibiboom.rabbitMQ.utils;

/**
 * @author Annie
 * @date 2021年07月02日 10:29
 */
public class SleepUtils {
    public static void sleep(int second){
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException _ignored) {
            Thread.currentThread().interrupt();
        }
    }
}
