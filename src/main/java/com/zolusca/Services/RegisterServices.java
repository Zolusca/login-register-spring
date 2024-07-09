package com.zolusca.Services;

import com.zolusca.DTO.UserMapper;
import com.zolusca.DTO.Request.UserRequest;
import com.zolusca.DTO.Responses.UserResponse;
import com.zolusca.Entities.RoleEnum;
import com.zolusca.Entities.Roles;
import com.zolusca.Entities.Users;
import com.zolusca.Exceptions.NotFoundExceptions;
import com.zolusca.Exceptions.AlreadyExistException;
import com.zolusca.Helpers.StringFormatterBuilder;
import com.zolusca.Repositories.RoleRepository;
import com.zolusca.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class RegisterServices {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserResponse userRegister(UserRequest userRequest){
        // checking user email
        Optional<Users> result = userRepository.findByEmail(userRequest.getEmail());

        // if email already exist, throw exception
        if(result.isPresent()){
            log.debug("user register failed email already exist {}",userRequest.getEmail());

            throw new AlreadyExistException("email already exist");
        }

        // mapping userReq to user and set default role as customer
        Users user = UserMapper.userObjectMapper.apply(userRequest);
        user.setRole(getDefaultRole());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);

        return UserResponse.builder()
                .email(userRequest.getEmail())
                .username(userRequest.getUsername())
                .role(user.getRole().getName().getRole())
                .build();
    }

    /**
     * creating default user role as CUSTOMER
     * @return Roles
     */
    private Roles getDefaultRole(){
        return roleRepository
                .findByName(RoleEnum.CUSTOMER)
                .orElseThrow(()->
                        new NotFoundExceptions(StringFormatterBuilder
                                .createFormattedString
                                        ("role %s not found",
                                        RoleEnum.CUSTOMER.getRole())
                        ));
    }
}
