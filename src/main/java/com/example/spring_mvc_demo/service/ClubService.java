package com.example.spring_mvc_demo.service;

import com.example.spring_mvc_demo.dto.ClubDto;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
}
