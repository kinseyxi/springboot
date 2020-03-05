package com.atguigu.amqp.service;
import com.atguigu.amqp.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {
   @RabbitListener(queues = "atguigu.news")
    public void receive(Book book){
       System.out.println("收到信息："+book);

   }
   @RabbitListener(queues = "gulixueyuan.news")
   public void receive02(Message message){
       System.out.println(message.getBody().toString());
       System.out.println(message.getMessageProperties());
   }
}
