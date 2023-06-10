package com.devsuperior.bds04.dto;

import com.devsuperior.bds04.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @Setter
    private Long id;
    @Setter
    @NotBlank(message = "Nome é obrigatório.")
    private String firstName;
    @Setter
    private String lastName;
    @Setter
    @Email(message = "Email deve ser válido.")
    private String email;
    private Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();
        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }

}
