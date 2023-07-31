package com.sofrecom.authentifmou3ina.response;
import java.util.List;

public class JwtResponse {
  private String token;
  private String type = "Bearer";
  private Long id;
  private String username;
  private String emailAdress;
  private List<String> roles;

  public JwtResponse(String accessToken, Long id, String username, String emailAdress, List<String> roles) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.emailAdress = emailAdress;
    this.roles = roles;
  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getemailAdress() {
    return emailAdress;
  }

  public void setemailAdress(String emailAdress) {
    this.emailAdress = emailAdress;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }
}
