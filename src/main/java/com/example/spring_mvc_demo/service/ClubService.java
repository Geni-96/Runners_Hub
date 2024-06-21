package com.example.spring_mvc_demo.service;

import com.example.spring_mvc_demo.dto.ClubDto;
import com.example.spring_mvc_demo.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();

    Club saveClub(ClubDto clubDto);

    void save();

    ClubDto findClubById(long clubId);

    void updateClub(ClubDto club);
}
