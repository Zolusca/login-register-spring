package com.zolusca.DTO;

import com.zolusca.DTO.Request.UserRequest;
import com.zolusca.Entities.Users;

import java.util.function.Function;

public class UserMapper {
    public static Function<UserRequest,Users> userObjectMapper = new Function<UserRequest,Users>() {
        @Override
        public Users apply(UserRequest userRequest) {
            Users user = new Users();

            user.setUsername(userRequest.getUsername());
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());

            return user;
        }
    };
}
