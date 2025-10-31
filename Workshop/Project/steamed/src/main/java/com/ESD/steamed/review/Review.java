package com.ESD.steamed.review;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
@Table()
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column()
    @Min(1)
    @Max(3)
    @NotNull
    //TODO: Make this int
    private Long rating;

    @Column(nullable = false, length = 2000)
    @NotNull
    private String comment;

    @Column()
    @NotNull
    private LocalTime created_at;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
