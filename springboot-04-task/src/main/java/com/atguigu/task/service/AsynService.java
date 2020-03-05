package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsynService {
    @Async
   public void hello(){
       //同步等待情况下
       try {
           Thread.sleep(7000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("处理数据中。。。");

   }
}
