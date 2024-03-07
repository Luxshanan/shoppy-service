package com.lcorp.shoppyservice.repository;

import com.lcorp.shoppyservice.model.Role;
import com.lcorp.shoppyservice.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}