package com.example.internet_provider.entity;

public enum Permission {
	SUBSCRIBER_READ("Subscriber:read"),
	SUBSCRIBER_WRITE("Subscriber:write");

	private final String permission;

	private Permission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	
	
	
	
}
