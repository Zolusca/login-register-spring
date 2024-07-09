package com.zolusca.DTO.Responses;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
public class UserResponse {
    private String username;
    private String email;
    private String role;
}
