package com.ESD.steamed.game;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class GameDTO {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDate releaseDate;
    private String developer;

}
