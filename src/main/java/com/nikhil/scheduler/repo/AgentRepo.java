package com.nikhil.scheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nikhil.scheduler.entity.Agent;

public interface AgentRepo extends JpaRepository<Agent, Integer> {

}