package br.com.tripplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.tripplanner.model.Trip;
import br.com.tripplanner.service.RegisterTripService;
import br.com.tripplanner.service.impl.TripServiceImpl;


@RestController
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api/trip")
public class TripController {
	
	@Autowired
	private TripServiceImpl tripService;
	
	@Autowired
	private RegisterTripService registerTrip;
	
	@RequestMapping(value="/find/all", method=RequestMethod.GET)
	public Iterable<Trip> getAll() {
		return tripService.getAll();
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public Trip createTrip(@RequestBody Trip trip){
		registerTrip.modifyTrip().setDestination("destino");
		return registerTrip.modifyTrip();
	}
	

}
