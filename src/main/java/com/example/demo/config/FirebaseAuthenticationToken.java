package com.example.demo.config;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import com.example.demo.model.FirebaseUser;
import com.google.firebase.auth.FirebaseToken;

public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {

	private String tokenFirebase;
	private FirebaseUser firebaseToken;
	
	public FirebaseAuthenticationToken(String token) {
		super(Arrays.asList());
		this.setTokenFirebase(token);
	}
	public FirebaseAuthenticationToken(String token, FirebaseUser user) {
		super(Arrays.asList());
		this.firebaseToken = user;
		this.setTokenFirebase(token);
	}
	
		public FirebaseAuthenticationToken(String token, Collection<? extends GrantedAuthority> authorities) {
		super(authorities);
		this.setTokenFirebase(token);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPrincipal() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getTokenFirebase() {
		return tokenFirebase;
	}
	public void setTokenFirebase(String tokenFirebase) {
		this.tokenFirebase = tokenFirebase;
	}
	

}
