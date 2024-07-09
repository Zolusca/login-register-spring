package com.zolusca.Services;

import com.zolusca.Entities.RoleEnum;
import com.zolusca.Entities.Roles;
import com.zolusca.Exceptions.AlreadyExistException;
import com.zolusca.Exceptions.NotFoundExceptions;
import com.zolusca.Helpers.StringFormatterBuilder;
import com.zolusca.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.AlreadyBoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleServices {
    @Autowired
    private RoleRepository roleRepository;

    public String createRole(Roles role){

        Optional<Roles> result = roleRepository.findByName(role.getName());

        if(result.isPresent()){
            String message = StringFormatterBuilder
                    .createFormattedString(
                            "role %s already exist",
                            role.getName());
            throw new AlreadyExistException(message);
        }

        roleRepository.save(role);
        return role.getName().toString();
    }

    public List<String> getRoleList(){

        // checking is role table empty
        if(roleRepository.count()<1){
            throw new NotFoundExceptions("record data role empty");
        }

        // get all data role and sorted by stream
        List<String> roles =  roleRepository.findAll()
                .stream()
                .map(data->data.getName().getRole())
                .sorted(String::compareTo)
                .toList();

        return roles;
    }
}
