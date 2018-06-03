package com.example.demo.controllers;

import static org.assertj.core.api.Assertions.entry;

import java.util.*;
import java.util.stream.Stream;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {
	
	@RequestMapping("/items")
	public String itemsPage() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth instanceof OAuth2Authentication) {
			OAuth2Authentication auth2 = (OAuth2Authentication)auth;
			Map<String, String> authDetails = (LinkedHashMap<String, String>)auth2.getUserAuthentication().getDetails();
			Optional<String> email = authDetails
						.entrySet()
						.stream()
						.filter(ent-> ent.getKey().equals("email"))
						.map(ent->ent.getValue())
						.findFirst();
			return "Hello world, "+email.get();
			
		}
		return "Nothing";
	}

}
