package com.sofrecom.authentifmou3ina.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.sofrecom.authentifmou3ina.entities.CleaningServicesCompany;
import com.sofrecom.authentifmou3ina.entities.Mou3inaEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
private static final long serialVersionUID = 1L;
private Long id;
private String username;
private String emailAdress;
@JsonIgnore
private String password;
private Collection<? extends GrantedAuthority> authorities;

//userdetails permet de recuperer les users from database
	//InMemoryUsersdetaails manager permet de creer des users automatiquement avec des roles pour ne pas avoir actual users in our database
	//GrantedAutority privilége indiv de l'user , considérer chaque rôle comme une GrantedAuthority

//contructeur
	public UserDetailsImpl(Long id, String username, String emailAdress, String password, Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.username = username;
		this.emailAdress = emailAdress;
		this.password = password;
		this.authorities = authorities;
	}
	public static UserDetailsImpl build(Object user) {
		if (user instanceof Mou3inaEntity) {
			Mou3inaEntity mou3inaEntity = (Mou3inaEntity) user;
			List<GrantedAuthority> authorities = mou3inaEntity.getRoles().stream()
					.map(roles -> new SimpleGrantedAuthority(roles.getName().name()))
					.collect(Collectors.toList());
			return new UserDetailsImpl(
					mou3inaEntity.getId(),
					mou3inaEntity.getUsername(),
					mou3inaEntity.getEmailAdress(),
					mou3inaEntity.getPassword(),
					authorities);
		}
		else if (user instanceof CleaningServicesCompany) {
			CleaningServicesCompany company = (CleaningServicesCompany) user;
			List<GrantedAuthority> authorities = company.getRoles().stream()
					.map(roles -> new SimpleGrantedAuthority(roles.getName().name()))
					.collect(Collectors.toList());
			return new UserDetailsImpl(
					company.getId(),
					company.getUsername(),
					company.getEmailAdress(),
					company.getPassword(),
					authorities);
		}
		throw new IllegalArgumentException("Invalid user type");

}



//GrantedAuthority : Une autorité qui est accordée au principal sur Authentication
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
return authorities;
}
public Long getId() {
return id;
}

public String getEmailAdress() {
	return emailAdress;
}
public void setEmailAdress(String emailAdress) {
	this.emailAdress = emailAdress;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public void setId(Long id) {
	this.id = id;
}
public void setUsername(String username) {
	this.username = username;
}
public void setPassword(String password) {
	this.password = password;
}
public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
}
@Override
public String getPassword() {
return password;
}
@Override
public String getUsername() {
return username;
}
@Override
public boolean isAccountNonExpired() {
return true;
}
@Override
public boolean isAccountNonLocked() {
return true;
}
@Override
public boolean isCredentialsNonExpired() {
return true;
}
@Override
public boolean isEnabled() {
return true;
}
@Override
public boolean equals(Object o) {
if (this == o)
return true;
if (o == null || getClass() != o.getClass())
return false;
UserDetailsImpl user = (UserDetailsImpl) o;
return Objects.equals(id, user.id);
}
}

