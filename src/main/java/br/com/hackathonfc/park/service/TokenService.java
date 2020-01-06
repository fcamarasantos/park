package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER_ = "Bearer ";

    public String generateToken(Authentication authentication){
            User user= (User) authentication.getPrincipal();
            Date today = new Date(System.currentTimeMillis());

            Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));

            return Jwts.builder()
                    .setSubject(user.getUsername())
                    .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                    .setExpiration(expirationDate)
                    .compact();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION);

        if (token == null || token.isEmpty() || !token.startsWith(BEARER_)) {
            return null;
        }

        return token.substring(7, token.length());
    }

    public String getUsername(String token) {
        Claims body = Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        return body.getSubject();
    }
}
