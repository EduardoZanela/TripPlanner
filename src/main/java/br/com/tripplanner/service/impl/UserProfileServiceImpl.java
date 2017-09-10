package br.com.tripplanner.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.tripplanner.model.Authority;
import br.com.tripplanner.model.UserProfile;
import br.com.tripplanner.repository.AuthorityRepository;
import br.com.tripplanner.repository.UserProfileRepository;
import br.com.tripplanner.service.UserProfileService;

@Service
public class UserProfileServiceImpl implements UserProfileService{

	@Autowired
    private UserProfileRepository userProfileRepository;
	 
	@Autowired
	private AuthorityRepository authorityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    //@PreAuthorize("hasRole('USER')")
    @Override
    public UserProfile findByUsername( String username ) throws UsernameNotFoundException {
    	UserProfile u = userProfileRepository.findByEmail(username);
        return u;
    }
    
    @Override
    //@PreAuthorize("hasRole('ADMIN')")
    public UserProfile findById( Long id ) throws AccessDeniedException {
    	UserProfile u = userProfileRepository.findOne( id );
        return u;
    }
    @Override
    //@PreAuthorize("hasRole('ADMIN')")
    public List<UserProfile> findAll() throws AccessDeniedException {
        List<UserProfile> result = (List<UserProfile>) userProfileRepository.findAll();
        return result;
    }

	@Override
	public UserProfile saveProfile(UserProfile user) {
		ArrayList<Authority> arrayList = new ArrayList<>();
		System.out.println("OLA"+ authorityRepository.findOne(1L).getName());
		arrayList.add(authorityRepository.findOne(1L));
		user.setAuthorities(arrayList);
		return userProfileRepository.save(user);
	}
    

}
