package br.com.tripplanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tripplanner.model.Trip;
import br.com.tripplanner.repository.TripRepository;
import br.com.tripplanner.service.TripService;

@Service
public class TripServiceImpl implements TripService {
	
	@Autowired
	private TripRepository repository;
	
	public Iterable<Trip> getAll(){
		return repository.findAll();
	}
	
}
