package com.zolusca.ServicesTest;

import com.zolusca.DTO.Request.UserRequest;
import com.zolusca.Services.RegisterServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRegisterServices {
    @Autowired
    RegisterServices registerServices;

    @Test
    void createUser(){
        Assertions.assertDoesNotThrow(()->{
            UserRequest userRequest = new UserRequest();
            userRequest.setUsername("admin");
            userRequest.setPassword("admin");
            userRequest.setEmail("admin@gmail.com");

            registerServices.userRegister(userRequest);
        });
    }
}
