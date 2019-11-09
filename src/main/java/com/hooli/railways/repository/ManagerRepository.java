package com.hooli.railways.repository;

import com.hooli.railways.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "manager")
public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Manager findByUsername(String username);
}
