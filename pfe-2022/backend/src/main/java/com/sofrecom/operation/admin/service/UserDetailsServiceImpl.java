package com.sofrecom.operation.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sofrecom.operation.admin.dao.CustomerRepository;
import com.sofrecom.operation.admin.entities.Customer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	CustomerRepository customerRepository;
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer user = customerRepository.findByUsername(username);
				//.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UserDetailsImpl.build(user);
	}
}