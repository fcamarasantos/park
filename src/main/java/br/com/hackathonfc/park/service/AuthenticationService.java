package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.model.Perfil;
import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.repository.PerfilRepository;
import br.com.hackathonfc.park.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> checkUser= userRepository.findByEmail(email);
        List<Perfil> perfis = perfilRepository.findAll();

        if (checkUser.isPresent()) {
            User user = checkUser.get();
            return new User(user.getEmail(), user.getPassword(), perfis);
        }

        throw new UsernameNotFoundException("Dados inválidos!");
    }
}