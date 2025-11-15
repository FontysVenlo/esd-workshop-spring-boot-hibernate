package com.ESD.steamed.review;

import com.ESD.steamed.game.GameDTO;
import com.ESD.steamed.user.UserDTO;
import lombok.Data;

import java.time.LocalTime;

@Data
public class ReviewDTO {

    private Long id;
    private String title;
    private Long rating;
    private String comment;
    private LocalTime createdAt;
    private GameDTO gameDTO;
    private UserDTO userDTO;

}
