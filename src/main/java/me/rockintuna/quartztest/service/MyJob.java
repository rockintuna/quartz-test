package me.rockintuna.quartztest.service;

import org.quartz.*;

// 실행할 Job 클래스
public class MyJob implements Job {
    public void execute(JobExecutionContext context) {
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String jobSays = dataMap.getString("jobSays");

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays);
    }
}
