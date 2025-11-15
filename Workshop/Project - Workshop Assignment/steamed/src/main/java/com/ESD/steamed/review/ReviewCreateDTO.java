package com.ESD.steamed.review;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ReviewCreateDTO {

    @NotNull
    private String title;
    @NotNull
    private Long rating;
    @NotNull
    private String comment;
    @NotNull
    private LocalTime createdAt;
    private Long gameId;
    private Long userId;

}
