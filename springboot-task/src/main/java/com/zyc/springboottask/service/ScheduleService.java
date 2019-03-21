package com.zyc.springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="zhuyichen">Zhu Yichen</a>
 * @version 1.0
 * @date 2019年03月16日 20:46
 * @desc ScheduleService 定时任务
 */
@Service
public class ScheduleService {

    @Scheduled(fixedRate = 1000)
    public void printTime(){
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * second(秒), minute（分）, hour（时）, day of month（日）, month（月）, day of week（周几）.
     * 0 * * * * MON-FRI
     *  【0 0/5 14,18 * * ?】 每天14点整，和18点整，每隔5分钟执行一次
     *  【0 15 10 ? * 1-6】 每个月的周一至周六10:15分执行一次
     *  【0 0 2 ? * 6L】每个月的最后一个周六凌晨2点执行一次
     *  【0 0 2 LW * ?】每个月的最后一个工作日凌晨2点执行一次
     *  【0 0 2-4 ? * 1#1】每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次；
     */
    /*  @Scheduled(cron = "0 * * * * MON-SAT")
     *  @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
     *  @Scheduled(cron = "0-4 * * * * MON-SAT")
     */

    @Scheduled(cron = "0/5 * * * * *")  //每5秒执行一次
    public void printHello(){
        System.out.println("hello......");
    }
}
