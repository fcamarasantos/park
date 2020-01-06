package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.UserDTO;
import br.com.hackathonfc.park.exception.PasswordNotValid;
import br.com.hackathonfc.park.exception.UsernameNotValid;
import br.com.hackathonfc.park.mapper.UserMAP;
import br.com.hackathonfc.park.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMAP userMAP;


    public ResponseEntity<UserDTO> cadastrar(UserDTO userDTO) throws UsernameNotValid, PasswordNotValid {
        if(ValidatePassword(userDTO.getPassword()) != true) {
            throw new PasswordNotValid();
        } else if(ValidateUsername(userDTO.getUsername()) != true){
            throw new UsernameNotValid();
        } else{
            return ResponseEntity.ok(userMAP.toDTO(userRepository.save(userMAP.fromDTO(userDTO))));

        }
    }

    private boolean ValidateUsername(String username){
        return true;
    }

    private boolean ValidatePassword(String password){
        return true;
    }
}
