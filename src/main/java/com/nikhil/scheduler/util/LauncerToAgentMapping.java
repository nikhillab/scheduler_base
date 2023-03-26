package com.nikhil.scheduler.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.nikhil.scheduler.agent.AgentType;
import com.nikhil.scheduler.agent.CommonAgent;
import com.nikhil.scheduler.agent.SpringAgent;
import com.nikhil.scheduler.launcher.CommonLauncher;
import com.nikhil.scheduler.launcher.Launcher;
import com.nikhil.scheduler.launcher.SpringLauncher;

@Component
public class LauncerToAgentMapping {
    @Autowired
    private ApplicationContext applicationContext;
    
    public Launcher<? extends AgentType> getLauncer(String launcher) {
        return switch (launcher) {
            case "CommonLauncher" -> new CommonLauncher<CommonAgent>();
            case "SpringLauncher" -> (SpringLauncher<SpringAgent>)applicationContext.getBean(SpringLauncher.class);
            default -> throw new IllegalArgumentException("Provided launcer does not exist " + launcher);
        };
    }

}
