package com.hooli.railways.repository;

import com.hooli.railways.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "route")
public interface RouteRepository extends JpaRepository<Route, Integer> {

}
