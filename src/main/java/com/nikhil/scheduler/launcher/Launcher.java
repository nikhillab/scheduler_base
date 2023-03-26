package com.nikhil.scheduler.launcher;

import com.nikhil.scheduler.agent.AgentType;

public interface Launcher<T extends AgentType> {
    public void setAgentName(String agentName);

    public void setAgentMethod(String agentMethod);

    public void setMethodType(Class methodType);

    public void setMethodArgumenObjects(Object... methodArgumenObjects);
}
