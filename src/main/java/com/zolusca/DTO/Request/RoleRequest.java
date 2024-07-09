package com.zolusca.DTO.Request;

import com.zolusca.Entities.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    private RoleEnum role;
}
