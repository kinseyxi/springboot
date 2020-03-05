package com.atguigu.amqp;
import com.atguigu.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot02AmqpApplicationTests {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    /**
     * 1.单播（点对点）
     */
    @Test
    void contextLoads() {
        //message需要自己构造一个，定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routerKey,message);
        //object默认当成消息体，只需要传入要发送的对象，自动序列化发给rabbitmq；
        //rabbitTemplate.convertAndSend(exchage,routekey,object);
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "这是第一个消息");
        map.put("data", Arrays.asList("helloworld", 123, true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct", "atguigu.news", new Book("西游记","吴承恩"));
    }
    //接受数据,如何将数据自动的转为JSON数据发送出去
    @Test
    public void receive(){
      Object o= rabbitTemplate.receiveAndConvert("atguigu.news");
      System.out.println(o.getClass());
      System.out.println(o);
    }
    /**
     * 广播
     */
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));

    }
    @Test
    public void createExchange(){
        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
        System.out.println("创建成功");
        amqpAdmin.declareQueue(new Queue("ampqadmin.queue",true));
    //创建绑定规则
        amqpAdmin.declareBinding(new Binding("ampqadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
    }

}
