package com.example.springbootjwt.repository;

import com.example.springbootjwt.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role , Long> {
    Role findByName(String name);
}
