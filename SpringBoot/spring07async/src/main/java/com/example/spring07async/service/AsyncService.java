package com.example.spring07async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AsyncService {

    @Async
    public void hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("正在处理数据中...已完成");
    }
//j
    //秒 分 时 日 月  周几~
    //  0 * * * * ? 每分钟的0秒
    //  30 10/5 10，18 * * ？ 每天10点和18点从第10分钟开始，每隔5分钟的30s执行一次
    //  0 15 10 ? * 1-6 每个月周一到周六的10点15分执行一次
    @Scheduled(cron = "0 * * * * ?")
    public void MySchedule(){
        System.out.println("定时任务， 启动！"+ new Date());
    }
}
