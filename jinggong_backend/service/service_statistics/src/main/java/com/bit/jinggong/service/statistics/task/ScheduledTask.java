package com.bit.jinggong.service.statistics.task;

import com.bit.jinggong.service.statistics.service.DailyService;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledTask {

    @Autowired
    private DailyService dailyService;

    //    @Scheduled(cron = "0/3 * * * * *")
    public void task1(){
        log.info("task1 在执行......");
    }

    //    @Scheduled(cron = "0 0 1 * * ?")
    @Scheduled(cron = "30 47 16 * * ?")
    public void testGenStatisticsData(){
        log.info("testGenStatisticsData 在执行......");
        String day = new DateTime().minusDays(1).toString("yyyy-MM-dd");
        dailyService.createStatisticsByDay(day);
    }
}

