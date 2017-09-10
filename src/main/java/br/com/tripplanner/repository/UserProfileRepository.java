package br.com.tripplanner.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.tripplanner.model.UserProfile;

@Repository
public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {
	UserProfile findByEmail(String username);
}
