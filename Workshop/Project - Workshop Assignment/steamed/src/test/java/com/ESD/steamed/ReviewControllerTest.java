package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameCreateDTO;
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
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Transactional
    void testCreateAndGetReview() throws Exception {
        GameCreateDTO gameCreateDTO = new GameCreateDTO();
        gameCreateDTO.setTitle("Test Game");
        gameCreateDTO.setDescription("Test game description");
        gameCreateDTO.setPrice(new BigDecimal("19.99"));
        gameCreateDTO.setReleaseDate(LocalDate.now());
        gameCreateDTO.setDeveloper("Test Dev");

        String gameResponse = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gameCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Test Game"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long gameId = objectMapper.readTree(gameResponse).get("id").asLong();

        ReviewCreateDTO reviewCreateDTO = new ReviewCreateDTO();
        reviewCreateDTO.setTitle("Awesome Game");
        reviewCreateDTO.setRating(3L);
        reviewCreateDTO.setComment("Really enjoyed it!");
        reviewCreateDTO.setCreatedAt(LocalTime.now());
        reviewCreateDTO.setGameId(gameId);

        String reviewResponse = mockMvc.perform(post("/reviews")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(reviewCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Awesome Game"))
                .andExpect(jsonPath("$.rating").value(3))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long reviewId = objectMapper.readTree(reviewResponse).get("id").asLong();

        mockMvc.perform(get("/reviews/{id}", reviewId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Awesome Game"))
                .andExpect(jsonPath("$.rating").value(3))
                .andExpect(jsonPath("$.comment").value("Really enjoyed it!"))
                .andExpect(jsonPath("$.gameDTO.id").value(gameId))
                .andExpect(jsonPath("$.gameDTO.title").value("Test Game"))
                .andExpect(jsonPath("$.gameDTO.description").value("Test game description"))
                .andExpect(jsonPath("$.gameDTO.price").value(19.99))
                .andExpect(jsonPath("$.gameDTO.developer").value("Test Dev"));
    }


}
