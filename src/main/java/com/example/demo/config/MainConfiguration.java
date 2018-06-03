package com.example.demo.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class MainConfiguration {
	@Autowired
	private ResourceLoader resourceLoader;

	@Bean
	public FirebaseApp firebaseBuyerApp() {

		Resource resource = resourceLoader.getResource("classpath:angularattack2018-firebase-adminsdk-ue8jc-22fc4ac455.json");

		FirebaseOptions options = null;
		try {
			options = new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(resource.getInputStream()))
					.setDatabaseUrl("https://angularattack2108.firebaseio.com/").build();
			return FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}