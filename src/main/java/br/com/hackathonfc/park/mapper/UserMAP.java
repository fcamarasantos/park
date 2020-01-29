package br.com.hackathonfc.park.mapper;

import br.com.hackathonfc.park.dto.UserDTO;
import br.com.hackathonfc.park.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMAP {

    public User fromDTO(UserDTO userDTO){
        return new User(userDTO);
    }

    public UserDTO toDTO(User user) {
        return new UserDTO(user);
    }
}
