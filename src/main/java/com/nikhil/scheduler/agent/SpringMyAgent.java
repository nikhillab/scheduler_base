package com.nikhil.scheduler.agent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nikhil.scheduler.repo.AgentRepo;

@Component(value="springMyAgent")
public class SpringMyAgent implements SpringAgent {

    @Autowired
    private AgentRepo agentRepo;

    @Override
    public void invoke() {
        System.out.println("SpringMyAgent invoce method");
        System.out.println(getAgentRepo().count());
        System.out.println("Done");
    }

    public AgentRepo getAgentRepo() {
        return agentRepo;
    }

    public void setAgentRepo(AgentRepo agentRepo) {
        this.agentRepo = agentRepo;
    }

}
