package com.scheduler.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "agent")
public class Agent {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkAgent;
    private String launcher;
    private String launcerMethod;
    private String agentName;
    private String agentMethod;
    private Integer agentNumber;
    private Integer clusterGroup;
    private String cronExpression;

    public Integer getPkAgent() {
        return pkAgent;
    }

    public void setPkAgent(Integer pkAgent) {
        this.pkAgent = pkAgent;
    }

    public String getLauncher() {
        return launcher;
    }

    public void setLauncher(String launcher) {
        this.launcher = launcher;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentMethod() {
        return agentMethod;
    }

    public void setAgentMethod(String agentMethod) {
        this.agentMethod = agentMethod;
    }

    public Integer getAgentNumber() {
        return agentNumber;
    }

    public void setAgentNumber(Integer agentNumber) {
        this.agentNumber = agentNumber;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getLauncerMethod() {
        return launcerMethod;
    }

    public void setLauncerMethod(String launcerMethod) {
        this.launcerMethod = launcerMethod;
    }

    public Integer getClusterGroup() {
        return clusterGroup;
    }

    public void setClusterGroup(Integer clusterGroup) {
        this.clusterGroup = clusterGroup;
    }

    @Override
    public String toString() {
        return "Agent [pkAgent=" + pkAgent + ", launcher=" + launcher + ", launcerMethod=" + launcerMethod
                + ", agentName=" + agentName + ", agentMethod=" + agentMethod + ", agentNumber=" + agentNumber
                + ", clusterGroup=" + clusterGroup + ", cronExpression=" + cronExpression + "]";
    }

}
