package com.example.internet_provider.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role implements GrantedAuthority {
	
	USER(Set.of(Permission.SUBSCRIBER_READ)),
	ADMIN(Set.of(Permission.SUBSCRIBER_READ, Permission.SUBSCRIBER_WRITE));
	
	private final Set<Permission> permissions;

	private Role(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public Set<SimpleGrantedAuthority> getAuthorities(){
		return getPermissions().stream()
				.map(perm -> new SimpleGrantedAuthority(perm.getPermission()))
				.collect(Collectors.toSet());
	}
	@Override
	public String getAuthority() {
		return name();
	}
	
}
