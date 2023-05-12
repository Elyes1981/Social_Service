package com.sofrecom.authentifmou3ina.services;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import com.sofrecom.authentifmou3ina.repository.CleaningCompanyRepository;
import com.sofrecom.authentifmou3ina.repository.Mou3inaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    Mou3inaRepository userRepository;

    @Autowired
    CleaningCompanyRepository cleaningCompanyRepository;
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CleaningServicesCompany company = cleaningCompanyRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        /*Mou3inaEntity mou3inaEntity = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));*/
        return UserDetailsImpl.build(company);
    }
}