package com.urzaizcoding.ebuisnesselektor.security.auth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.google.common.collect.Lists;
import com.urzaizcoding.ebuisnesselektor.security.ApplicationUserRole;

@Repository
@Primary
public class InMemoryApplicationUserDAO implements ApplicationUserDetailsDAO {
	
	private final PasswordEncoder passEncoder;

	
	@Autowired
	public InMemoryApplicationUserDAO(PasswordEncoder passEncoder) {
		super();
		this.passEncoder = passEncoder;
	}



	@Override
	public Optional<UserDetails> loadUserByUsername(String username) {
		return getApplicationUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst();
	}



	@Override
	public List<UserDetails> getApplicationUsers() {
		ArrayList<UserDetails> users = Lists.newArrayList(
				new ApplicationUser(ApplicationUserRole.ADMIN.getGrantedAuthorities(),
						"urzaiz",
						"naruffygo",
						true,
						true,
						true,
						true)
		);
		return users;
	}

}
