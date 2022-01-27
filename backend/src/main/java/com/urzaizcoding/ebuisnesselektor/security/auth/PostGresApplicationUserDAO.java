package com.urzaizcoding.ebuisnesselektor.security.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


@Component
public class PostGresApplicationUserDAO implements ApplicationUserDetailsDAO{
	
//	private final 

	@Override
	public Optional<UserDetails> loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserDetails> getApplicationUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
