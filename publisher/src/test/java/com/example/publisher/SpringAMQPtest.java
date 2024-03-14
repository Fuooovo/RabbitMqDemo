package com.example.publisher;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Fuooovo
 * @Date 2024/3/13
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringAMQPtest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    //Basic Queue
    @Test
    public void testSendMessage2BasicQueue(){
        String queueName="simple.queue";
        String message="hello,Spring AMQP!";
        rabbitTemplate.convertAndSend(queueName,message);
    }

    //Work Queue
    @Test
    public void testSendMessage2WorkQueue() throws InterruptedException {
        String queueName="simple.queue";
        String message="This is message--";
        for(int i=1;i<=50;i++){
            rabbitTemplate.convertAndSend(queueName,message+i);
            Thread.sleep(20);
        }
    }

    //Fanout Exchange
    @Test
    public void testSendMessage2FanOutExchange(){
        //交换机名称
        String exchangeName="fuooovo.fanout";
        //消息
        String message="hello,everyone!";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"",message);
    }

    //Direct Exchange
    @Test
    public void testSendMessage2DirectExchange(){
        //交换机名称
        String exchangeName="fuooovo.direct";
        //消息
        String message="hello,red";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"red",message);
    }


    //Direct Exchange
    @Test
    public void testSendMessage2TopicExchange(){
        //交换机名称
        String exchangeName="fuooovo.topic";
        //消息
        String message="hello,china.news";
        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,"china.news",message);
    }

    @Test
    public void sendObjectMessage(){
        Map<String,Object> msg=new HashMap<>();
        msg.put("姓名","张三");
        msg.put("年龄","18");
        rabbitTemplate.convertAndSend("object.queue",msg);
    }


}
