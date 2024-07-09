package com.zolusca.Controllers;

import com.zolusca.DTO.Request.UserRequest;
import com.zolusca.DTO.Responses.ApiResponses;
import com.zolusca.DTO.Responses.UserResponse;
import com.zolusca.Services.RegisterServices;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/api/user/register")
public class UserRegisterController {
    @Autowired
    private RegisterServices userRegisterServices;

    @PostMapping(
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ApiResponses<UserResponse>> createUser(
            @Valid @RequestBody UserRequest userRequest
    )
    {
        UserResponse result = userRegisterServices.userRegister(userRequest);

        log.info("success create new user {}",userRequest.getEmail());

        return new ResponseEntity<>
                (
                        new ApiResponses<>(
                                HttpStatus.CREATED.value(),
                                null,
                                result),
                        HttpStatus.CREATED
                );
    }
}
