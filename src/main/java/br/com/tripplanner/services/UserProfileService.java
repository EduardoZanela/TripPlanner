package br.com.tripplanner.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tripplanner.models.UserProfile;
import br.com.tripplanner.repository.UserProfileRepository;

@Service
public class UserProfileService {
	
	@Autowired
	private UserProfileRepository repository;
	
	public UserProfile getbyId(Long id){
		return repository.findOne(id);
	}
	
	public void saveProfile(UserProfile user){
		repository.save(user);
	}

}
