package com.zolusca.ServicesTest;

import com.zolusca.Entities.RoleEnum;
import com.zolusca.Entities.Roles;
import com.zolusca.Services.RoleServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoleServicesTest {
    @Autowired
    RoleServices roleServices;

    @Test
    void createRoleTest(){
        Assertions.assertDoesNotThrow(()->{

            Roles role = new Roles();
            role.setName(RoleEnum.CUSTOMER);

            roleServices.createRole(role);
        });
    }
}
