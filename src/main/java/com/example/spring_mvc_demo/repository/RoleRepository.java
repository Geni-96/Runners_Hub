package com.example.spring_mvc_demo.repository;

import com.example.spring_mvc_demo.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

}
