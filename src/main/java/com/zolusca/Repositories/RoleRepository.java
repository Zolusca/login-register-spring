package com.zolusca.Repositories;

import com.zolusca.Entities.RoleEnum;
import com.zolusca.Entities.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles> findByName(RoleEnum role);
}
