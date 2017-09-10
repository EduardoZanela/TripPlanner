package br.com.tripplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import br.com.tripplanner.model.UserProfile;
import br.com.tripplanner.service.UserProfileService;

@RestController
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class UserProfileController {

	@Autowired
	private UserProfileService userService;
		
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public UserProfile saveUser(@RequestBody UserProfile user){
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		
		return userService.saveProfile(user);
	}
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(value="/obterusuariobyid/{userId}")
	public UserProfile getUser(@PathVariable String userId){
		Long id = Long.parseLong(userId);
		return userService.findById(id);
	}
	
	//TODO implementar via post com json e email no corpo
	@RequestMapping(value="/obterusuariobyemail/{useremail}")
	public UserProfile getUserByEmail(@PathVariable String useremail){
		return userService.findByUsername(useremail);
	}
}
