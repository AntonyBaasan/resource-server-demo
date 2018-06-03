package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class FirebaseAuthenticationProvider implements AuthenticationProvider  {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if(!supports(authentication.getClass()))
			return null;
		
		FirebaseAuthenticationToken token = (FirebaseAuthenticationToken) authentication;
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(FirebaseAuthenticationToken.class);
	}

}
