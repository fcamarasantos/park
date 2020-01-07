package br.com.hackathonfc.park.dto;

import br.com.hackathonfc.park.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Long id;

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    public UserDTO(User user) {
        this.id = user.getId();
        this.email = user.getUsername();
        this.password = user.getPassword();
    }
}
