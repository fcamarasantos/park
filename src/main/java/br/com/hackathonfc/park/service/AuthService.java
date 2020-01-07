package br.com.hackathonfc.park.service;

import br.com.hackathonfc.park.model.User;
import br.com.hackathonfc.park.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private Random random = new Random();

    public ResponseEntity<User>sendNewPassword(String email) throws UsernameNotFoundException {
        Optional<User> checkUser = userRepository.findByEmail(email);

        if (checkUser.isPresent()){
            User user = checkUser.get();
            String newPassword = newPassword();
            System.out.println(newPassword);
            user.setPassword(bCryptPasswordEncoder.encode(newPassword));
            userRepository.save(user);
            return ResponseEntity.ok(user);
        } else {
            throw new UsernameNotFoundException("No user found with email " + email);
        }
    }

    private String newPassword() {
        char[] vet = new char[8];
        for (int i = 0; i< 8; i++){
            vet[i] = randomChar();
        }
        return new String(vet);
    }

    private char randomChar() {
        int opt = random.nextInt(3);

        if (opt == 0){
            return (char) (random.nextInt(10) + 48);
        } else if (opt == 1){
            return (char) (random.nextInt(26) + 65);
        } else {
            return (char) (random.nextInt(26) + 97);
        }
    }

}
