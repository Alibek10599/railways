package com.hooli.railways.repository;

import com.hooli.railways.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "train")
public interface TrainRepository extends JpaRepository<Train, Integer> {
    List<Train> findAllByRouteId(Integer routeId);
}
