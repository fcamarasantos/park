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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public ResponseEntity<UserDTO> detalhar(Long id) throws UsernameNotFoundException{
        Optional<User> checkUser = userRepository.findById(id);

        if(checkUser.isPresent()){
            return ResponseEntity.ok(userMAP.toDTO(checkUser.get()));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado no sistema!");
        }
    }

    public ResponseEntity<UserDTO> atualizar(Long id, UserDTO userDTO) throws UsernameNotFoundException{
        Optional<User> checkUser = userRepository.findById(id);

        if(checkUser.isPresent()){
           User user = checkUser.get();
           user.setEmail(userDTO.getEmail());
           user.setPassword(userDTO.getPassword());
           userRepository.save(user);
           return ResponseEntity.ok(userMAP.toDTO(user));
        } else {
            throw new UsernameNotFoundException("Usuário não encontrado no sistema!");
        }
    }

    public ResponseEntity<Void> remover(Long id) throws UsernameNotFoundException{
        Optional<User> checkUser = userRepository.findById(id);

        if (checkUser.isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else{
            throw new UsernameNotFoundException("Usuário não encontrado no sistema!");
        }
    }

    public static User authenticated(){
        try {
            return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e){
            return null;
        }
    }

    private boolean validateEmail(String email) throws UsernameNotValid {
        Optional<User> checkUser = userRepository.findByEmail(email);

        if (checkUser.isPresent()){
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword(String password){
        if (password == null || password.isEmpty() || password.length() < 8){
            return false;
        } else {
            return true;
        }
    }
}
