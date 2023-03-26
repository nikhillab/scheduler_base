package com.nikhil.scheduler.launcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.nikhil.scheduler.agent.SpringAgent;

@Component(value="springLauncher")
public class SpringLauncher<T extends SpringAgent> extends AbstractLauncer<T> {

    @Autowired
    private ApplicationContext applicationContext;

    public void invoke() {
        agent = (T) applicationContext.getBean(getAgentName(), SpringAgent.class);
        agent.invoke();
    }

}
