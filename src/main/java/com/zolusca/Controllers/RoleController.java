package com.zolusca.Controllers;

import com.zolusca.DTO.Request.RoleRequest;
import com.zolusca.DTO.Responses.ApiResponses;
import com.zolusca.Entities.RoleEnum;
import com.zolusca.Entities.Roles;
import com.zolusca.Services.RoleServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "/api/roles")
public class RoleController {
    @Autowired
    private RoleServices roleServices;
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponses<String>> createRoles
            (
                    @RequestBody RoleRequest roleReq
            )
    {
        Roles role = new Roles();
        role.setName(roleReq.getRole());

        roleServices.createRole(role);

        log.info("success create new role {} ",roleReq.getRole());

        return new ResponseEntity<>
                (
                 new ApiResponses<String>
                                (HttpStatus.CREATED.value(),
                                null,
                                role.getName().getRole())
                ,HttpStatus.CREATED
                );
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponses<List<String>>> getRoleList(){

        List<String> roles = roleServices.getRoleList();

        return new ResponseEntity<>
                (
                  new ApiResponses<>(
                          HttpStatus.OK.value(),
                          null,
                          roles
                  ),
                  HttpStatus.OK
                );
    }
}
