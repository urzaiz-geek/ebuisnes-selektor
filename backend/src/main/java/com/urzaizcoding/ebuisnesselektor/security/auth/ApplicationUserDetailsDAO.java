package com.urzaizcoding.ebuisnesselektor.security.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;

public interface ApplicationUserDetailsDAO {

	Optional<UserDetails> loadUserByUsername(String username);
	
	List<UserDetails> getApplicationUsers();
	
}
