package com.atguigu.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.ticket.service.TicketService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class UserService {
   @Reference
    TicketService ticketService;
   public String payticket(){
       String ticket = ticketService.getTicket();
       System.out.println("买到票了:"+ticket);
       return "买到票了:"+ticket;
   }
}
