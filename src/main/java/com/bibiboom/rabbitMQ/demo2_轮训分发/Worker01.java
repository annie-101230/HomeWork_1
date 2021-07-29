package com.bibiboom.rabbitMQ.demo2_轮训分发;

import com.bibiboom.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * @author Annie
 * @date 2021年07月02日 9:29
 */
public class Worker01 {

    private static final String QUEUE_NAME = "hello";

    public static void main(String[] args) throws Exception{

        Channel channel = RabbitMqUtils.getChannel();
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("收到消息: " + new String(message.getBody()));
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + " 消费者取消消费接口回调逻辑'***'");
        };
        System.out.println("C2消费者启动了 , 等待消费 ... ...");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}
