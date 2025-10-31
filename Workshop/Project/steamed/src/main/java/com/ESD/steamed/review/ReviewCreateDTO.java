package com.ESD.steamed.review;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ReviewCreateDTO {

    private String title;
    private Long rating;
    private String comment;
    private LocalTime createdAt;
    private Long gameId;
}
