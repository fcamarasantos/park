package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.dto.UserDTO;
import br.com.hackathonfc.park.exception.PasswordNotValid;
import br.com.hackathonfc.park.exception.UsernameNotValid;
import br.com.hackathonfc.park.mapper.UserMAP;
import br.com.hackathonfc.park.model.Perfil;
import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private UserMAP userMAP;

    @Autowired
    private DbService dbService;

    @Autowired
    private PerfilService perfilService;

    public ResponseEntity<UserDTO> cadastrar(UserDTO userDTO) throws UsernameNotValid, PasswordNotValid {
        if(validatePassword(userDTO.getPassword()) != true) {
            throw new PasswordNotValid();
        } else if(validateEmail(userDTO.getEmail()) != true){
            throw new UsernameNotValid();
        } else{
            User user = userRepository.save(new User(userDTO.getEmail(), dbService.encode(userDTO.getPassword())));
           return ResponseEntity.ok(new UserDTO(user));
        }
    }

    public UserDTO detalhar(Long id) throws UsernameNotFoundException{
        Optional<User> checkUser = userRepository.findById(id);
        User user = UserService.authenticated();
        Perfil perfilAdmin = perfilService.detalhar(1L);

        if(checkUser.isPresent()){
            if(user==null || !user.hasRole(perfilAdmin) && !id.equals(user.getId())) {
                throw new AuthorizationServiceException("Acess danied!");
            } else {
                return new UserDTO(checkUser.get());
            }
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

        User user = UserService.authenticated();

        Perfil perfil = perfilService.detalhar(1L);

        if (checkUser.isPresent()){
            if(user!=null && user.hasRole(perfil)) {
                userRepository.deleteById(id);
                return ResponseEntity.ok().build();
            } else
                throw new AuthorizationServiceException("Acess danied!");
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

    private boolean validateEmail(String email){
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
