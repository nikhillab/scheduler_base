package com.scheduler.launcher;

import com.scheduler.agent.AgentType;

public abstract class AbstractLauncer<T  extends AgentType> implements Launcher<T> {
    protected T agent;
	protected String agentName;
	protected String agentMethod;
	protected Class methodType;
	protected Object[] methodArgumenObjects;
    
    public String getAgentName() {
		return agentName;
	}

	public String getAgentMethod() {
		return agentMethod;
	}

	@Override
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	@Override
	public void setAgentMethod(String agentMethod) {
		this.agentMethod = agentMethod;
	}

	@Override
	public void setMethodType(Class methodType) {
		this.methodType = methodType;
	}

	@Override
	public void setMethodArgumenObjects(Object... methodArgumenObjects) {
		this.methodArgumenObjects = methodArgumenObjects;
	}
}
