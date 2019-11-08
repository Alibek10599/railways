package com.hooli.railways.repository;

import com.hooli.railways.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "train")
public interface TrainRepository extends JpaRepository<Train, Integer> {

}
