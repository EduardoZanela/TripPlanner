package br.com.tripplanner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.tripplanner.model.Authority;
import br.com.tripplanner.repository.AuthorityRepository;
import br.com.tripplanner.service.AuthorityService;

public class AuthorityServiceImpl implements AuthorityService{

	@Autowired
	private AuthorityRepository repository;
	
	@Override
	public void saveAuthority(Authority auth) {
		repository.save(auth);
	}

}
