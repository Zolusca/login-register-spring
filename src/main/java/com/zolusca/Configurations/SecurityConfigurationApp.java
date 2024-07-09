package com.zolusca.Configurations;

import com.zolusca.Services.AuthUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurationApp {
    @Autowired
    private AuthUserDetails authUserDetails;

    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf->csrf.disable())
                .authorizeHttpRequests(
                        auth->{
                            auth.requestMatchers(HttpMethod.POST,"/api/user/register").permitAll();
                            auth.requestMatchers("/api/roles").hasAuthority("ADMIN");
                            auth.anyRequest().authenticated();
                        }
                )
                .userDetailsService(authUserDetails)
                .httpBasic(Customizer.withDefaults())
                .build();

    }
}
