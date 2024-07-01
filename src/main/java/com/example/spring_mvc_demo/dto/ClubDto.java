package com.example.spring_mvc_demo.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ClubDto {

    private Long id;
    @NotEmpty(message="Club title cannot be empty")
    private String title;
    @NotEmpty(message="Photo link cannot be empty")
    private String photoUrl;
    @NotEmpty(message="Content cannot be empty")
    private String content;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<EventDto> events;
}
