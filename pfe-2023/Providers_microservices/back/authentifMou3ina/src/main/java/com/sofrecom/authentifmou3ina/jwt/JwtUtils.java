package com.sofrecom.authentifmou3ina.jwt;


import java.util.Date;

import com.sofrecom.authentifmou3ina.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;



import io.jsonwebtoken.*;
@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwtExpirationMs}")
    private int jwtExpirationMs;
    public String generateJwtToken(Authentication authentication) {

        //Authentication  which contains the user's authentication information.

        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();  //UserDetailsImpl, an implementation of Spring Security's UserDetails interface.
        return Jwts.builder()  //The Jwts.builder() method is used to create a new JWT builder object.
        .setSubject((userPrincipal.getUsername()))  //setSubject method is used to set the subject of the JWT, which is typically the username or ID of the authenticated user.
        .setIssuedAt(new Date())  //method sets the time the JWT was issued,
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))  //setExpiration method sets the expiration time of the JWT
        .signWith(SignatureAlgorithm.HS512, jwtSecret)    //aHS512lgorithme  to sign the JWT with a secret key
        .compact();  //method is used to compact the JWT into a string format and return it.
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }
    public boolean validateJwtToken(String authToken) {


        try {


            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {


            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }
}

