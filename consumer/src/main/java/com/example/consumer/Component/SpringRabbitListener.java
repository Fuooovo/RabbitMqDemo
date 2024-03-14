package com.example.consumer.Component;



import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

/**
 * @Author Fuooovo
 * @Date 2024/3/13
 * @Description
 */
@Component
public class SpringRabbitListener {

    //Basic Queue模型只有一个消费者
    /*
    @RabbitListener(queues = "simple.queue")
    public void listenBasicQueue(String msg) throws InterruptedException{
        System.out.println("SpinrgAMQP 消费者接收到消息 : [" + msg + "]");
    }*/

    //Work Queue模型有两个消费者
    /*
    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue1(String msg) throws InterruptedException{
        System.out.println("消费者1接收到消息 : [" + msg + "]"+ LocalTime.now());
        Thread.sleep(20);//休眠20毫秒，1秒钟接收50条消息
    }
    @RabbitListener(queues = "simple.queue")
    public void listenWorkQueue2(String msg) throws InterruptedException{
        System.err.println("消费者2接收到消息 : [" + msg + "]"+LocalTime.now());//err打印出来是红色，以便区分两个消费者
        Thread.sleep(200);//休眠200毫秒，1秒钟接收5条消息
    }*/

    /*
    //FanoutExchange模型
    @RabbitListener(queues = "fanout.queue1")
    public void listenFanoutQueue1(String msg) throws InterruptedException{
        System.out.println("Fanout Exchange-消费者1接收到fanout.queue1的消息 : [" + msg + "]");
    }
    @RabbitListener(queues = "fanout.queue2")
    public void listenFanoutQueue2(String msg) throws InterruptedException{
        System.out.println("Fanout Exchange-消费者2接收到fanout.queue2的消息 : [" + msg + "]");
    }*/

    /*
    //DirectExchange模型
    @RabbitListener(bindings = @QueueBinding(
            value=@Queue(name="direct.queue1"),
            exchange = @Exchange(name="fuooovo.direct",type= ExchangeTypes.DIRECT),
            key={"red","blue"}

    ))
    public void listenDirectQueue1(String msg) throws InterruptedException{
        System.out.println("Direct Exchange-消费者1接收到direct.queue1的消息 : [" + msg + "]");
    }
    @RabbitListener(bindings = @QueueBinding(
            value=@Queue(name="direct.queue2"),
            exchange = @Exchange(name="fuooovo.direct",type= ExchangeTypes.DIRECT),
            key={"red","yellow"}

    ))
    public void listenDirectQueue2(String msg) throws InterruptedException{
        System.out.println("Direct Exchange-消费者2接收到direct.queue2的消息 : [" + msg + "]");
    }*/

    /*
    //Topic Exchange模型
    @RabbitListener(bindings = @QueueBinding(
            value=@Queue(name="topic.queue1"),
            exchange = @Exchange(name="fuooovo.topic",type=ExchangeTypes.TOPIC),
            key="china.#"
    ))
    public void listenTopicQueue1(String msg) throws InterruptedException{
        System.out.println("Topic Exchange-消费者1接收到topic.queue1的消息 : [" + msg + "]");
    }
    @RabbitListener(bindings = @QueueBinding(
            value=@Queue(name="topic.queue2"),
            exchange = @Exchange(name="fuooovo.topic",type=ExchangeTypes.TOPIC),
            key="#.news"
    ))
    public void listenTopicQueue2(String msg) throws InterruptedException{
        System.out.println("Topic Exchange-消费者2接收到topic.queue2的消息 : [" + msg + "]");
    }*/

    //object反序列化获取json数据
    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String,Object> msg) throws InterruptedException{
        System.out.println("收到消息：["+msg+"]");
    }
}
