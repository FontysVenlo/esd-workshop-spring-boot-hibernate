package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameCreateDTO;
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
}
