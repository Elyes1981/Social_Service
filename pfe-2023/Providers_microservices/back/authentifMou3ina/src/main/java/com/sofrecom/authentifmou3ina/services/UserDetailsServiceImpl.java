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
        Optional<CleaningServicesCompany> companyOptional = cleaningCompanyRepository.findByUsername(username);
        Optional<Mou3inaEntity> mou3inaOptional = userRepository.findByUsername(username);
        if (mou3inaOptional.isPresent()) {
            Mou3inaEntity mou3inaEntity = mou3inaOptional.get();
            return UserDetailsImpl.build(mou3inaEntity);
        } else if (companyOptional.isPresent()) {
            CleaningServicesCompany company = companyOptional.get();
            return UserDetailsImpl.build(company);
        } else {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }
}