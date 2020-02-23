package com.lastrada.website.lastrada;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lastrada.website.lastrada.model.Credentials;
import com.lastrada.website.lastrada.repository.CredentialsRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private CredentialsRepository credentialsRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials userCredentials = credentialsRepo.findByUsername(username);
		   if (userCredentials == null) {
	            throw new UsernameNotFoundException(username);
	        }
	        return new User(userCredentials.getUsername(),userCredentials.getPassword(),new ArrayList<>());
	}

}
