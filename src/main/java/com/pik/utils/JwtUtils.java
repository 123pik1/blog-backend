package com.pik.utils;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
    private final String jwtSecret = "twoj_bardzo_dlugi_i_bezpieczny_klucz_ktory_ma_przynajmniej_32_znaki";
    private final int jwtExpirationTime = 3600000;

    private final SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

    public String generateToken(Authentication authentication) {
        // UserDetails userDetails = (UserDetails) authentication.getDetails();
        String username = authentication.getName();
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date((new Date().getTime() + jwtExpirationTime)))
                .signWith(key)
                .compact();
    }

    // Getting login from token
    public String getNameFromToken(String token) {
        return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject();
    }

    public boolean validateToken(String authtoken) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(authtoken);
            return true;
        } catch (JwtException | IllegalArgumentException e) {

        }
        return false;
    }

}
