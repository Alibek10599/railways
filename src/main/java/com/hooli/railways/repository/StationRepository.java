package com.hooli.railways.repository;

import com.hooli.railways.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "station")
public interface StationRepository extends JpaRepository<Station, String> {
}
