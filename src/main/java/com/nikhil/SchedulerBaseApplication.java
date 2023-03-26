package com.nikhil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.util.MethodInvoker;

import com.nikhil.datasource.config.DataSourceConfig;
import com.nikhil.datasource.routing.ThreadLocalStorage;
import com.nikhil.scheduler.repo.AgentRepo;
import com.nikhil.scheduler.util.LauncerToAgentMapping;

@SpringBootApplication
@Import(DataSourceConfig.class)
public class SchedulerBaseApplication implements CommandLineRunner {

	@Autowired
	Scheduler scheduler;
	@Autowired
	AgentRepo agentRepo;
	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	LauncerToAgentMapping launcerToAgentMapping;

	public static void main(String[] args) {
		SpringApplication.run(SchedulerBaseApplication.class, args);
	}

	public void run(String... args) {
		ThreadLocalStorage.setTenantName("scheduledb".toUpperCase());
		var list = agentRepo.findAll();
		System.out.println("Agents to runs is  " + list.size());
		list.forEach(agent -> {
			try {
				var launcher = launcerToAgentMapping.getLauncer(agent.getLauncher());
				launcher.setAgentName(agent.getAgentName());
				launcher.setAgentMethod(agent.getAgentMethod());
				launcher.setMethodType(ApplicationContext.class);
				launcher.setMethodArgumenObjects(applicationContext);

				MethodInvoker invoker = new MethodInvoker();
				invoker.setTargetObject(launcher);
				invoker.setTargetMethod(agent.getLauncerMethod());
				invoker.prepare();

				ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Kolkata"));

				JobDataMap dataMap = new JobDataMap();
				dataMap.put("methodInvoker", invoker);

				JobDetail detail = JobBuilder.newJob(MethodInvokingJobDetailFactoryBean.StatefulMethodInvokingJob.class)
						.withIdentity("JOB_" + agent.getAgentNumber(), "JOB_GRP_" + agent.getAgentNumber())
						.usingJobData(dataMap).storeDurably().requestRecovery().build();

				Trigger trigger = TriggerBuilder.newTrigger()
						.withIdentity("TRIGGER_" + agent.getAgentNumber(), "TRIGGER_GRP_" + agent.getAgentNumber())
						.startAt(Date.from(zonedDateTime.toInstant()))
						.withSchedule(CronScheduleBuilder.cronSchedule(agent.getCronExpression())).build();
				
				scheduler.scheduleJob(detail, trigger);
			} catch (ClassNotFoundException | NoSuchMethodException | SchedulerException e) {
				e.printStackTrace();
			}
		});

	}

}
