package com.home.jblog.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

//	public List<User> findAll() {
//		return userRepository.findAll();
//	}
//
//	public User save(User user) {
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRepository.save(user);
//	}

	@PostConstruct
	public void init() {
		//User autumn = userRepository.findByUsername("autumn");
		User autumn = null;
		if (autumn == null) {
			User user = new User();
			user.setName("autumn");
			user.setPassword("pass");
			//System.out.println(this.save(user));
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//User user = userRepository.findByUsername(username);
		User user = null;
		user = new User();
		
		user.setName("jyh1234");
		user.setPassword("1234");
		
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(),
				getAuthorities());
	}

	private Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
