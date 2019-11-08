package com.hooli.railways.repository;

import com.hooli.railways.entity.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "agent")
public interface AgentRepository extends JpaRepository<Agent, String> {

}
