package br.com.hackathonfc.park.controller;

import br.com.hackathonfc.park.dto.UserDTO;
import br.com.hackathonfc.park.exception.PasswordNotValid;
import br.com.hackathonfc.park.exception.UsernameNotValid;
import br.com.hackathonfc.park.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/signup")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> register(@RequestBody @Valid UserDTO userDTO) throws UsernameNotValid, PasswordNotValid {
        return userService.cadastrar(userDTO);
    }

}
