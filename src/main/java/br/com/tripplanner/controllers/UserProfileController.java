package br.com.tripplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.tripplanner.models.UserProfile;
import br.com.tripplanner.services.UserProfileService;

@RestController
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api")
public class UserProfileController {

	@Autowired
	private UserProfileService service;
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveUser(@RequestBody UserProfile user){
		service.saveProfile(user);
		return "saved";
	}
	
	@RequestMapping(value="/obterusuario/{userId}")
	public UserProfile getUser(@PathVariable String userId){
		Long id = Long.parseLong(userId);
		return service.getbyId(id);
	}
}
