package com.nikhil.scheduler.agent;

import org.springframework.stereotype.Component;

@Component
public non-sealed interface SpringAgent extends AgentType{
    public void invoke();
}
