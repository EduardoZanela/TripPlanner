package br.com.tripplanner.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.tripplanner.models.UserProfile;

public interface UserProfileRepository extends CrudRepository<UserProfile, Long> {

}
