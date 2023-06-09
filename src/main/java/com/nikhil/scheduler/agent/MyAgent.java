package com.nikhil.scheduler.agent;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.nikhil.datasource.routing.ThreadLocalStorage;
import com.nikhil.scheduler.repo.AgentRepo;

@Component
public final class MyAgent implements CommonAgent {

	@Override
	public void run(ApplicationContext applicationContext) {
		System.out.println(ThreadLocalStorage.getTenantName());
		System.out.println(Thread.currentThread().getName() + " Triggred at : " + LocalDateTime.now());
		AgentRepo agentRepo = applicationContext.getBean(AgentRepo.class);
		var list = agentRepo.findAll();
		System.out.println(list);
	}
}
