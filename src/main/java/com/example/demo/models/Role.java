package com.example.demo.models;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum Role {

	
	USER(Set.of(Permission.Doljnost_READ)),
	ADMIN(Set.of(Permission.Doljnost_READ,Permission.Doljnost_WRITE));
	private final Set<Permission>permissions;
	Role(Set<Permission>t)
	{
		this.permissions=t;
	}
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public Set<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return getPermissions().stream().map(permission->new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
	}

}
