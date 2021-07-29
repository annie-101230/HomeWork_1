package com.bibiboom.rabbitMQ.demo3_手动应答;

import com.bibiboom.rabbitMQ.utils.RabbitMqUtils;
import com.bibiboom.rabbitMQ.utils.SleepUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;

/**
 * @author Annie
 * @date 2021年07月02日 10:23
 */
public class Work03 {
    private static final String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C1等待接收消息处理时间较短 ... ...");
        // 消息消费的时候如何处理消息
        DeliverCallback deliverCallback = (consumerTag, message) ->{
            SleepUtils.sleep(1);
            System.out.println("消费者消费消息: " + new String(message.getBody()));
            // 1.消息标记tag  2.是否批量应答消息
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + " 消费者取消消费接口回调逻辑'***'");
        };
        // 手动应答
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, cancelCallback);
    }
}
