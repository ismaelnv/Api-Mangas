package com.villarruel.mangas.Security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    private static final String KEY = "SM77794261";

    public String generateToken(UserDetails UserDetails) {
        return Jwts.builder().setSubject(UserDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 18))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(token)) && !istokenExpired(token);
    }

    public String extractUsername(String token) {
        return getclaims(token).getSubject();
    }

    public boolean istokenExpired(String token) {
        return getclaims(token).getExpiration().before(new Date());
    }

    private Claims getclaims(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

}
