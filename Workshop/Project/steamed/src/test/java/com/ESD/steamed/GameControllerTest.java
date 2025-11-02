package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameCreateDTO;
import com.ESD.steamed.review.Review;
import com.ESD.steamed.review.ReviewCreateDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void testCreateAndGetGame() throws Exception {

        GameCreateDTO newGame = new GameCreateDTO();
        newGame.setTitle("Hollow Knight");
        newGame.setDescription("Epic 2D action-platformer with exploration and tight combat.");
        newGame.setPrice(new BigDecimal("14.99"));
        newGame.setReleaseDate(LocalDate.of(2017, 2, 24));
        newGame.setDeveloper("Team Cherry");

        System.out.println(objectMapper.writeValueAsString(newGame));

        String response = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newGame)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Hollow Knight"))
                .andReturn()
                .getResponse()
                .getContentAsString();


        Game createdGame = objectMapper.readValue(response, Game.class);

        mockMvc.perform(get("/games/{id}", createdGame.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Hollow Knight"))
                .andExpect(jsonPath("$.description").value("Epic 2D action-platformer with exploration and tight combat."))
                .andExpect(jsonPath("$.price").value(14.99))
                .andExpect(jsonPath("$.developer").value("Team Cherry"))
                .andExpect(jsonPath("$.releaseDate").value("2017-02-24"));
    }

    @Test
    @Transactional
    void testCreateReviewForGame() throws Exception {

        GameCreateDTO newGame = new GameCreateDTO();
        newGame.setTitle("Hollow Knight");
        newGame.setDescription("Epic 2D action-platformer with exploration and tight combat.");
        newGame.setPrice(new BigDecimal("14.99"));
        newGame.setReleaseDate(LocalDate.of(2017, 2, 24));
        newGame.setDeveloper("Team Cherry");

        String gameResponse = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newGame)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Hollow Knight"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long gameId = objectMapper.readTree(gameResponse).get("id").asLong();

        LocalTime time = LocalTime.of(12, 0);

        ReviewCreateDTO reviewCreateDTO = new ReviewCreateDTO();
        reviewCreateDTO.setTitle("Awesome Game");
        reviewCreateDTO.setRating(3L);
        reviewCreateDTO.setComment("Really enjoyed it!");
        reviewCreateDTO.setCreatedAt(time);
        reviewCreateDTO.setGameId(gameId);

        String reviewResponse = mockMvc.perform(post("/games/{id}/reviews", gameId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reviewCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Awesome Game"))
                .andExpect(jsonPath("$.rating").value(3))
                .andExpect(jsonPath("$.comment").value("Really enjoyed it!"))
                .andExpect(jsonPath("$.createdAt").value("12:00:00"))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }
}
