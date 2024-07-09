package com.zolusca.DTO.Responses;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponses <T>{
    private Integer code;
    private List<String> error;
    private T data;
}
