package com.df.datax.task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 利用spring定时任务调起job
 */
@Component
public class JobTask {

//    每天中午12点触发
    @Scheduled(cron = "0 0 12 * * ?")
    public void taskTeradataJob() {
        System.out.println("每天中午12点触发配置定时任务");
    }
//    上午10:15触发
    @Scheduled(cron = "0 15 10 * * ?")
    public void taskMysqlJob(){
        System.out.println("每日的上午10:15触发定时任务");
    }
//    每天上午10点，下午2点，4点
    @Scheduled(cron = "0 0 10,14,16 * * ?")
    public void taskJob(){
        System.out.println("每天上午10点，下午2点，4点定时任务");
    }

}
