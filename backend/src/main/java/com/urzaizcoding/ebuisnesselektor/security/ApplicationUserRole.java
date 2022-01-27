package com.urzaizcoding.ebuisnesselektor.security;

import com.google.common.collect.Sets;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum ApplicationUserRole {
	
	EMPLOYE(Sets.newHashSet()),
	MANAGER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet());
	
	private final Set<ApplicationPermission> authorities;
	ApplicationUserRole(Set<ApplicationPermission> authorities) {
		this.authorities = authorities;
		
	}
	
	public Set<ApplicationPermission> getAuthorities(){
		return this.authorities;
	}
	
	public Set<GrantedAuthority> getGrantedAuthorities(){
		Set<GrantedAuthority> collect = getAuthorities()
				.stream()
				.map(p -> new SimpleGrantedAuthority(p.getPermission()))
				.collect(Collectors.toSet());
		collect.add(new SimpleGrantedAuthority("ROLE_"+this.name()));	//All roles start with "ROLE_"
		return collect;
	}
}
