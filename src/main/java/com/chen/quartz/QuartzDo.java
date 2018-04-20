package com.chen.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzDo {

	public static void main(String[] args) throws SchedulerException {
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler scheduler = sf.getScheduler();
		
		JobDetail job = JobBuilder.newJob(JobImp.class).withIdentity("Job", "JobGroup").withDescription("this is describle").
				build();
		
		Trigger trigger = TriggerBuilder.newTrigger().startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
				.build();
//		Trigger trigger1 = TriggerBuilder.newTrigger().startNow()
//				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(0))
//				.build();
		
		scheduler.scheduleJob(job, trigger);
		System.out.println("begin again!!");
		scheduler.start();
	}
}
