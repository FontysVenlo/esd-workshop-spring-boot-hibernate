package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import com.ESD.steamed.game.GameCreateDTO;
import com.ESD.steamed.game.GameMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GameMapper gameMapper;


    @BeforeEach
    @Transactional
    void setup() throws Exception {
        GameTestSetup gameTestSetup = new GameTestSetup();
        List<GameCreateDTO> createDTOs = gameMapper.toCreateDTOList(gameTestSetup.getGames());
        for (GameCreateDTO createDTO : createDTOs) {
            mockMvc.perform(post("/games")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(createDTO)))
                    .andExpect(status().isCreated());
        }
    }

    @Test
    @Transactional
    void testCreateGame() throws Exception {

        GameCreateDTO newGame = new GameCreateDTO();
        newGame.setTitle("Hollow Knight");
        newGame.setDescription("Epic 2D action-platformer with exploration and tight combat.");
        newGame.setPrice(new BigDecimal("14.99"));
        newGame.setReleaseDate(LocalDate.of(2017, 2, 24));
        newGame.setDeveloper("Team Cherry");

        String response = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newGame)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Hollow Knight"))
                .andReturn()
                .getResponse()
                .getContentAsString();
    }

    @Test
    @Transactional
    void testGetAllGames() throws Exception {
        mockMvc.perform(get("/games"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(8));
    }

    @Test
    @Transactional
    void testGetGameById() throws Exception {

        GameCreateDTO newGame = new GameCreateDTO();
        newGame.setTitle("Hollow Knight");
        newGame.setDescription("Epic 2D action-platformer with exploration and tight combat.");
        newGame.setPrice(new BigDecimal("14.99"));
        newGame.setReleaseDate(LocalDate.of(2017, 2, 24));
        newGame.setDeveloper("Team Cherry");

        String response = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newGame)))
                .andExpect(status().isCreated())
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
    void testGetGameByWrongId() throws Exception {

        mockMvc.perform(get("/games/{id}", 12))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User not found with ID: " + 12));
            
    }

    @Test
    @Transactional
    void testUpdateGame() throws Exception {

        GameCreateDTO newGame = new GameCreateDTO();
        newGame.setTitle("Hollow Knight");
        newGame.setDescription("Epic 2D action-platformer with exploration and tight combat.");
        newGame.setPrice(new BigDecimal("14.99"));
        newGame.setReleaseDate(LocalDate.of(2017, 2, 24));
        newGame.setDeveloper("Team Cherry");

        String response = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newGame)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Hollow Knight"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Game createdGame = objectMapper.readValue(response, Game.class);

        GameCreateDTO gameToUpdate = new GameCreateDTO();
        gameToUpdate.setTitle("Hollow Knight 2");
        gameToUpdate.setDescription("Boring second game of the series");
        gameToUpdate.setPrice(new BigDecimal("25"));
        gameToUpdate.setReleaseDate(LocalDate.of(2019, 4, 24));
        gameToUpdate.setDeveloper("Team Cherry");

        mockMvc.perform(put("/games/{id}", createdGame.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gameToUpdate)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Hollow Knight 2"))
                .andExpect(jsonPath("$.description").value("Boring second game of the series"))
                .andExpect(jsonPath("$.price").value(25))
                .andExpect(jsonPath("$.developer").value("Team Cherry"))
                .andExpect(jsonPath("$.releaseDate").value("2019-04-24"));

        Game updatedGame = objectMapper.readValue(response, Game.class);

        mockMvc.perform(get("/games/{id}", createdGame.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Hollow Knight 2"))
                .andExpect(jsonPath("$.description").value("Boring second game of the series"))
                .andExpect(jsonPath("$.price").value(25))
                .andExpect(jsonPath("$.developer").value("Team Cherry"))
                .andExpect(jsonPath("$.releaseDate").value("2019-04-24"));
    }

    @Test
    @Transactional
    void testGetAllGamesWithLowerPrice() throws Exception {
        BigDecimal maxPrice = new BigDecimal("10.99");

        mockMvc.perform(get("/games")
                        .param("maxPrice", maxPrice.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}
