package com.bibiboom.rabbitMQ.demo2_轮训分发;

import com.bibiboom.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;

import java.util.Scanner;

/**
 * @author Annie
 * @date 2021年07月02日 10:03
 */
public class Task01 {
    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{

        Channel channel = RabbitMqUtils.getChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        // 从控制台中接收消息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println("消息发送完成: " + message);
        }
    }
}
