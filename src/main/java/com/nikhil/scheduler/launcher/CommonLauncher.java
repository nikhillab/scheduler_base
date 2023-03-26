package com.nikhil.scheduler.launcher;

import java.time.LocalDateTime;

import com.nikhil.scheduler.agent.AgentType;
import com.nikhil.scheduler.agent.CommonAgent;

@SuppressWarnings("all")
public class CommonLauncher<T extends CommonAgent> extends AbstractLauncer<T> {

	public void run() {
		try {
			Class<? extends T> targetClass = (Class<? extends T>) Class.forName(getAgentName());
			agent = (T) targetClass.getConstructor().newInstance(null);
			targetClass.getMethod(getAgentMethod(), methodType).invoke(agent, methodArgumenObjects);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
