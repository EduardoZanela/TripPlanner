package br.com.tripplanner.service;

import java.util.List;

import br.com.tripplanner.model.UserProfile;

public interface UserProfileService {
    UserProfile findById(Long id);
    UserProfile findByUsername(String username);
    List<UserProfile> findAll ();
    UserProfile saveProfile(UserProfile user);
}
