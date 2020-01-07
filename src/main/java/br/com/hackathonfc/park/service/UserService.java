package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.UserDTO;
import br.com.hackathonfc.park.exception.PasswordNotValid;
import br.com.hackathonfc.park.exception.UsernameNotValid;
import br.com.hackathonfc.park.mapper.UserMAP;
import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMAP userMAP;


    public ResponseEntity<UserDTO> cadastrar(UserDTO userDTO) throws UsernameNotValid, PasswordNotValid {
        if(validatePassword(userDTO.getPassword()) != true) {
            throw new PasswordNotValid();
        } else if(validateEmail(userDTO.getEmail()) != true){
            throw new UsernameNotValid();
        } else{
            return ResponseEntity.ok(userMAP.toDTO(userRepository.save(userMAP.fromDTO(userDTO))));

        }
    }

    public static User authenticated(){
        try {
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e){
            return null;
        }
    }

    private boolean validateEmail(String email){
        return true;
    }

    private boolean validatePassword(String password){
        return true;
    }
}
