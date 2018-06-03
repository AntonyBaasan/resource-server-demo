package com.example.demo.model;

public class FirebaseUser {

	private String uid;
	private String name;
	private String email;

	public FirebaseUser(String uid, String name, String email) {
		this.setUid(uid);
		this.setName(name);
		this.setEmail(email);
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
