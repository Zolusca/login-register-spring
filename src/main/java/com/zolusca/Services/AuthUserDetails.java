package com.zolusca.Services;

import com.zolusca.Entities.Users;
import com.zolusca.Exceptions.NotFoundExceptions;
import com.zolusca.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetails implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository
                .findByUsername(username)
                .orElseThrow(()-> new NotFoundExceptions("email or username not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities("ADMIN")
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
