package com.spring.veeru.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.veeru.dao.UserRepository;
import com.spring.veeru.models.MyUserDetails;
import com.spring.veeru.models.User;
/**
 * @author virupaksha.kuruva
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		System.out.println("Given userName:"+userName);
		Optional<User> user =  userRepository.findByUserName(userName);
		System.out.println("DB user:"+user.get().getUserName());
		user.orElseThrow(() ->new UsernameNotFoundException("User not found: "+userName));
		return user.map(MyUserDetails::new).get();
	}

}
