package com.zolusca.DTO.Request;

import com.zolusca.Entities.RoleEnum;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "username cannot blank")
    @Length(min = 5, max = 50,message = "length must be at least 5 - 5 character")
    private String username;
    @Length(min = 8,message = "length minimum 8 character")
    @NotBlank(message = "password cannot blank")
    private String password;
    @NotBlank(message = "email cannot blank")
    @Email(message = "must be valid email")
    private String email;
}
