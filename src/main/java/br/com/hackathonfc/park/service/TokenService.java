package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class TokenService {

    @Value("${jwt.expiration}")
    private String expiration;

    @Value("${jwt.secret}")
    private String secret;

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER_ = "Bearer ";

    public String generateToken(String username){
            Date today = new Date(System.currentTimeMillis());

            Date expirationDate = new Date(today.getTime() + Long.parseLong(expiration));

            return Jwts.builder()
                    .setSubject(username)
                    .signWith(SignatureAlgorithm.HS256, secret.getBytes())
                    .setExpiration(expirationDate)
                    .compact();
    }

    public ResponseEntity<Void> refreshToken (HttpServletResponse httpServletResponse){
        User user = UserService.authenticated();
        String token = generateToken(user.getUsername());
        httpServletResponse.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
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
