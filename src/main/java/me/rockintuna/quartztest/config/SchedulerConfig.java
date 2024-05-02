package me.rockintuna.quartztest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SchedulerConfig {
    @Autowired
    private DataSource dataSource;

//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(ApplicationContext applicationContext) {
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setDataSource(dataSource);
//        schedulerFactoryBean.setWaitForJobsToCompleteOnShutdown(true);
//        return schedulerFactoryBean;
//    }
}
