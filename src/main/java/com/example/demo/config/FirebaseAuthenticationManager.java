//package com.example.demo.config;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//import com.example.demo.model.FirebaseUser;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseAuthException;
//import com.google.firebase.auth.FirebaseToken;
//
//@Component
//public class FirebaseAuthenticationManager implements AuthenticationManager {
//
//	@Override
//	public Authentication authenticate(Authentication auth) throws AuthenticationException {
//		System.out.println("Hello world!!!!!!!!!!!!!!!!!!");
//		
//		FirebaseAuthenticationToken authentication = (FirebaseAuthenticationToken) auth;
//		String token = authentication.getTokenFirebase();
//		
//		FirebaseToken decodedToken;
//		try {
//			decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
//		
//			authentication.setDetails(this.createFirebaseUser(decodedToken));
//			
//		} catch (FirebaseAuthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return authentication;
//	}
//	
//	private FirebaseUser createFirebaseUser(FirebaseToken firebaseToken) {
//		return new FirebaseUser(firebaseToken.getUid(), firebaseToken.getName(), firebaseToken.getEmail());
//	}
//}
