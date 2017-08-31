package br.com.tripplanner.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.tripplanner.models.Trip;

public interface TripRepository extends CrudRepository<Trip, Long> {

}
