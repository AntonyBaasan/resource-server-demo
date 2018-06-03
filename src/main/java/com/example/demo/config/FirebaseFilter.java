package com.example.demo.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.model.FirebaseUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FirebaseFilter extends OncePerRequestFilter {

	private String HEADER_NAME = "X-Authorization-Firebase";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String xAuth = request.getHeader(HEADER_NAME);
		if (xAuth.isEmpty()) {
			filterChain.doFilter(request, response);
			return;
		} else {
			try {

				FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(xAuth);
				Authentication auth = new FirebaseAuthenticationToken(xAuth, this.createFirebaseUser(decodedToken));
				SecurityContextHolder.getContext().setAuthentication(auth);

				filterChain.doFilter(request, response);
			} catch (FirebaseAuthException e) {
				throw new SecurityException(e);
			}
		}

	}
	
	private FirebaseUser createFirebaseUser(FirebaseToken firebaseToken) {
		return new FirebaseUser(firebaseToken.getUid(), firebaseToken.getName(), firebaseToken.getEmail());
	}

}
