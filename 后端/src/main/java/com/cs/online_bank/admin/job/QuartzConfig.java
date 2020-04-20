package com.cs.online_bank.admin.job;

import javax.annotation.Resource;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

@Configuration
public class QuartzConfig {
	@Resource
	private JobFactory jobFactory;
	@Bean
	JobDetailFactoryBean jobDetail() {
		JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(MyJob.class);
		jobDetailFactoryBean.setDurability(true);
		return jobDetailFactoryBean;
	}
	@Bean
	JobDetailFactoryBean jobDetail2() {
		JobDetailFactoryBean jobDetailFactoryBean=new JobDetailFactoryBean();
		jobDetailFactoryBean.setJobClass(MyJob2.class);
		jobDetailFactoryBean.setDurability(true);
		return jobDetailFactoryBean;
	}
	
	@Bean
	CronTriggerFactoryBean cronTriggerFactoryBean() {
		CronTriggerFactoryBean cronTriggerFactoryBean=new CronTriggerFactoryBean();
		cronTriggerFactoryBean.setJobDetail(jobDetail().getObject());
		cronTriggerFactoryBean.setCronExpression("0 0 0 * * ?");
		return cronTriggerFactoryBean;
	}
	@Bean
	CronTriggerFactoryBean cronTriggerFactoryBean2() {
		CronTriggerFactoryBean cronTriggerFactoryBean2=new CronTriggerFactoryBean();
		cronTriggerFactoryBean2.setJobDetail(jobDetail().getObject());
		cronTriggerFactoryBean2.setCronExpression("0 0 21 * * ?");
		return cronTriggerFactoryBean2;
	}
	@Bean
	SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();
		CronTrigger cronTrigger=cronTriggerFactoryBean().getObject();
		CronTrigger cronTrigger2=cronTriggerFactoryBean2().getObject();
		schedulerFactoryBean.setTriggers(cronTrigger,cronTrigger2);
		schedulerFactoryBean.setJobFactory(jobFactory);
		return schedulerFactoryBean;
	}
}
