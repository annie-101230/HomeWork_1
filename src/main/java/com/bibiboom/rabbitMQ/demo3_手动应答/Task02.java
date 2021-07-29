package com.bibiboom.rabbitMQ.demo3_手动应答;

import com.bibiboom.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.util.Scanner;

/**
 * @author Annie
 * @date 2021年07月02日 10:19
 */
public class Task02 {
    private static final String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        channel.basicQos(1);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.nextLine();
            channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            System.out.println("发送了消息: " + message);
        }
    }
}
