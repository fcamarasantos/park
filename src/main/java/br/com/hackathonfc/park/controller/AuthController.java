package br.com.hackathonfc.park.controller;

import br.com.hackathonfc.park.dto.EmailDTO;
import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.service.AuthService;
import br.com.hackathonfc.park.service.TokenService;
import br.com.hackathonfc.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthService authService;

    @PostMapping("/refresh_token")
    public ResponseEntity<Void> refreshToken(HttpServletResponse httpServletResponse){
        return tokenService.refreshToken(httpServletResponse);
    }

    @PostMapping("/forgot")
    public ResponseEntity<User> forgot(@RequestBody EmailDTO emailDTO){
        return authService.sendNewPassword(emailDTO.getEmail());
    }


}
