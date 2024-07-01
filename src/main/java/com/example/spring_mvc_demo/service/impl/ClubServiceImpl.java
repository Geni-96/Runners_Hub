package com.example.spring_mvc_demo.service.impl;

import com.example.spring_mvc_demo.dto.ClubDto;
import com.example.spring_mvc_demo.models.Club;
import com.example.spring_mvc_demo.repository.ClubRepository;
import com.example.spring_mvc_demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.spring_mvc_demo.mapper.ClubMapper.maptoClub;
import static com.example.spring_mvc_demo.mapper.ClubMapper.maptoClubDto;

@Service
public class ClubServiceImpl implements ClubService {
    private ClubRepository clubRepository;


    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> maptoClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club = maptoClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public void save() {

    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();
        return  maptoClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = maptoClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> maptoClubDto(club)).collect(Collectors.toList());
    }

}
