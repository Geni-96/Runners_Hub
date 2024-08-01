package com.example.spring_mvc_demo.service.impl;

import com.example.spring_mvc_demo.dto.RegistrationDto;
import com.example.spring_mvc_demo.models.Role;
import com.example.spring_mvc_demo.models.UserEntity;
import com.example.spring_mvc_demo.repository.RoleRepository;
import com.example.spring_mvc_demo.repository.UserRepository;
import com.example.spring_mvc_demo.service.UserService;

import java.util.Arrays;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(RegistrationDto registrationDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(registrationDto.getUsername());
        userEntity.setEmail(registrationDto.getEmail());
        userEntity.setPassword(registrationDto.getPassword());

        Role role = roleRepository.findByName("USER");
        userEntity.setRoles(Arrays.asList(role));
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
