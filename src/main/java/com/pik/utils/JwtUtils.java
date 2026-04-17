package com.pik.utils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
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

        List<String> autorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return Jwts.builder()
                .subject(username)
                .claim("roles", autorities)
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

    public List<GrantedAuthority> getAuthoritiesFromToken(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();

        List<String> roles = claims.get("roles", List.class);
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }
}
