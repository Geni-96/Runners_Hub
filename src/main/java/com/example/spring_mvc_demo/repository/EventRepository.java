package com.example.spring_mvc_demo.repository;

import com.example.spring_mvc_demo.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
