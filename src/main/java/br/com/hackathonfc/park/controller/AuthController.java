package br.com.hackathonfc.park.controller;

import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.service.TokenService;
import br.com.hackathonfc.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse httpServletResponse){
        User user = UserService.authenticated();
        String token = tokenService.generateToken(user.getUsername());
        httpServletResponse.addHeader("Authorization", "Bearer " + token);
        return ResponseEntity.noContent().build();
    }
}
