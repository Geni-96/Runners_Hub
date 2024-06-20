package com.example.spring_mvc_demo.repository;

import com.example.spring_mvc_demo.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club>findByTitle(String url);
}
