package br.com.tripplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.tripplanner.model.Trip;
import br.com.tripplanner.service.TripService;


@RestController
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api")
public class TripController {
	
	@Autowired
	private TripService service;
	
	@RequestMapping(value="/obtertodos", method=RequestMethod.GET)
	public Iterable<Trip> getAll() {
		return service.getAll();
	}
	

}
