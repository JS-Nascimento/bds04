package com.devsuperior.bds04.dto;


import com.devsuperior.bds04.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private Long id;
    private String authority;

    public RoleDTO(Role entity) {
        id = entity.getId();
        authority = entity.getAuthority();
    }

}
