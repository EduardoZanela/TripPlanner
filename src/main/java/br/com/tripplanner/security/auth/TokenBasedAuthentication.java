package br.com.tripplanner.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.com.tripplanner.model.UserProfile;

@Component
public class TokenBasedAuthentication extends AbstractAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private String token;
	
    private final UserProfile principle;

    public TokenBasedAuthentication( UserDetails principle ) {
        super( principle.getAuthorities() );
        this.principle = (UserProfile) principle;
    }

    public String getToken() {
        return token;
    }

    public void setToken( String token ) {
        this.token = token;
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public UserDetails getPrincipal() {
        return principle;
    }

}