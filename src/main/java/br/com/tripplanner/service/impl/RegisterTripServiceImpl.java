package br.com.tripplanner.service.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import br.com.tripplanner.model.Trip;
import br.com.tripplanner.service.RegisterTripService;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class RegisterTripServiceImpl implements RegisterTripService{
	
	private Trip trip;
	
	@Override
	public Trip modifyTrip(){
		return this.trip;
	}

}
