package com.scheduler.agent;

import org.springframework.context.ApplicationContext;

public non-sealed interface CommonAgent extends AgentType{
    public void run(ApplicationContext applicationContext);

}
