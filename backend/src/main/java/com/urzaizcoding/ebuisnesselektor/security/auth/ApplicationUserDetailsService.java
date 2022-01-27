package com.urzaizcoding.ebuisnesselektor.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
	private final ApplicationUserDetailsDAO applicationUserDetailsDAO;

	@Autowired
	public ApplicationUserDetailsService(ApplicationUserDetailsDAO applicationUserDetailsDAO) {
		super();
		this.applicationUserDetailsDAO = applicationUserDetailsDAO;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return applicationUserDetailsDAO.loadUserByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("Username : %s", username)));
	}

}
