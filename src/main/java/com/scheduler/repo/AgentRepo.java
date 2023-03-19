package com.scheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scheduler.entity.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {

}