package com.hooli.railways.repository;

import com.hooli.railways.entity.StationsRoutes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "stationsroutes")
public interface StationsRoutesRepository extends JpaRepository<StationsRoutes, Integer> {

}
