package com.zolusca.DTO.Request;

import com.zolusca.Entities.RoleEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleRequest {
    @NotBlank(message = "email cannot blank")
    private String email;
    @NotEmpty(message = "role cannot empty")
    private RoleEnum role;
}
