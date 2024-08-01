package com.example.spring_mvc_demo.service;

import com.example.spring_mvc_demo.dto.RegistrationDto;
import com.example.spring_mvc_demo.models.UserEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
