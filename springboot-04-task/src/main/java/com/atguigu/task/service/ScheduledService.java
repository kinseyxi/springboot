package com.atguigu.task.service;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /**
     * second(秒),minute(分),hour(时),day of month(日),month(月),day of week(星期), year(年)
     * 0 * * * * MON-SAT
     */
    @Scheduled(cron = "0 * * * * MON-SAT")
    public void hello(){
        System.out.println("hello定时任务。。。。");
    }
}
