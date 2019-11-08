package com.hooli.railways.repository;

import com.hooli.railways.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "passenger")
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    List<Passenger> findAllByUsername(String username);
}
