package br.com.tripplanner.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tripplanner.model.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
