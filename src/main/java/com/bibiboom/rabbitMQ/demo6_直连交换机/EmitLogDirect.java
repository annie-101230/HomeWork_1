package com.bibiboom.rabbitMQ.demo6_直连交换机;

import com.bibiboom.rabbitMQ.utils.RabbitMqUtils;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Annie
 * @date 2021年07月14日 11:47
 */
public class EmitLogDirect {

    private static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws Exception {

        try (Channel channel = RabbitMqUtils.getChannel()) {
            channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);
            // 创建多个 bindingKey
            Map<String, String> bindingKeyMap = new HashMap<>();
            bindingKeyMap.put("info","普通 info 信息");
            bindingKeyMap.put("warning","警告 warning 信息");
            bindingKeyMap.put("error","错误 error 信息");
            // debug 没有消费这接收这个消息 所有就丢失了
            bindingKeyMap.put("debug","调试 debug 信息");
            for (Map.Entry<String, String> bindingKeyEntry : bindingKeyMap.entrySet()) {
                String bindingKey = bindingKeyEntry.getKey();
                String message = bindingKeyEntry.getValue();
                channel.basicPublish(EXCHANGE_NAME, bindingKey, null, message.getBytes("UTF-8"));
                System.out.println("生产者发出消息:" + message);
            }
        }
    }
}
