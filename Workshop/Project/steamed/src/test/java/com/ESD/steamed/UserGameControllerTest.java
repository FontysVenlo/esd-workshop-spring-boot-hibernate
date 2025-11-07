package com.ESD.steamed;

import com.ESD.steamed.game.GameCreateDTO;
import com.ESD.steamed.userGame.UserGameCreateDTO;
import com.ESD.steamed.user.UserCreateDTO;
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
public class UserGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void testAddGameToLibrary() throws Exception {

        UserCreateDTO userCreateDTO = new UserCreateDTO("TestUser","","");
        userCreateDTO.setUsername("TestUser");
        userCreateDTO.setEmail("testuser@example.com");
        userCreateDTO.setPassword("securePassword");

        String userResponse = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("TestUser"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(userResponse).get("id").asLong();

        GameCreateDTO gameCreateDTO = new GameCreateDTO();
        gameCreateDTO.setTitle("Library Test Game");
        gameCreateDTO.setDescription("A test game for library integration");
        gameCreateDTO.setPrice(new BigDecimal("14.99"));
        gameCreateDTO.setReleaseDate(LocalDate.now());
        gameCreateDTO.setDeveloper("Integration Dev");

        String gameResponse = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gameCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Library Test Game"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long gameId = objectMapper.readTree(gameResponse).get("id").asLong();

        UserGameCreateDTO createDTO = new UserGameCreateDTO();
        createDTO.setUserId(userId);
        createDTO.setGameId(gameId);

        mockMvc.perform(post("/userGames/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.user.username").value("TestUser"))
                .andExpect(jsonPath("$.game.title").value("Library Test Game"))
                .andExpect(jsonPath("$.purchaseDate").exists());
    }
}
