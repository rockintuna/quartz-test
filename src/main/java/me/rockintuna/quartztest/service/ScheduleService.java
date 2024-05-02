package me.rockintuna.quartztest.service;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    private Scheduler scheduler;

//    private SchedulerFactoryBean schedulerFactoryBean;

//    @Autowired
//    public ScheduleService(SchedulerFactoryBean schedulerFactoryBean) {
//        this.schedulerFactoryBean = schedulerFactoryBean;
//        try {
//            scheduler = this.schedulerFactoryBean.getScheduler();
//            scheduler.start();
//        } catch (SchedulerException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public void stopSchedule() {
        try {
            scheduler.shutdown();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void pauseSchedule() {
        try {
            scheduler.pauseAll();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void resumeSchedule() {
        try {
            scheduler.resumeAll();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void unregisterJob(String key) {
        JobKey jobKey = new JobKey(key, "group");
        try {
            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    public void registerJob(String key, String message) {
        JobDetail job = JobBuilder.newJob(MyJob.class)
                .withIdentity(key, "group")
                .usingJobData("jobSays", message)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(job.getKey().getName(), "group")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())
                .build();
        try {
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
