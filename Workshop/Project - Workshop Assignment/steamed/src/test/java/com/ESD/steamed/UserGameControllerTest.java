package com.ESD.steamed;

import com.ESD.steamed.game.GameCreateDTO;
import com.ESD.steamed.game.GameDTO;
import com.ESD.steamed.game.GameMapper;
import com.ESD.steamed.userGame.UserGameCreateDTO;
import com.ESD.steamed.user.UserCreateDTO;
import com.ESD.steamed.userGame.UserGameDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GameMapper gameMapper;

    @Test
    @Transactional
    void testAddGameToLibrary() throws Exception {

        Long userId = createUser();
        Long gameId = createGame();

        UserGameCreateDTO createDTO = new UserGameCreateDTO();
        createDTO.setGameId(gameId);

        mockMvc.perform(post("/userGames/users/{id}/games", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.user.username").value("TestUser"))
                .andExpect(jsonPath("$.gameDTO.title").value("Library Test Game"))
                .andExpect(jsonPath("$.purchaseDate").exists());
    }

    @Test
    @Transactional
    void testAddGameToLibraryWrongUserId() throws Exception {

        Long userId = 123L;
        Long gameId = createGame();

        UserGameCreateDTO createDTO = new UserGameCreateDTO();
        createDTO.setGameId(gameId);

        mockMvc.perform(post("/userGames/users/{id}/games", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User not found with ID: " + userId));
    }

    @Test
    @Transactional
    void testAddGameToLibraryWrongGameId() throws Exception {

        Long userId = createUser();
        Long gameId = 123123L;

        UserGameCreateDTO createDTO = new UserGameCreateDTO();
        createDTO.setGameId(gameId);

        mockMvc.perform(post("/userGames/users/{id}/games", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(createDTO)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Game not found with ID: " + gameId));
    }

    @Test
    @Transactional
    void testGetUserLibrary() throws Exception{
        Long userId = createUser();
        List<Long> gameIds = setupUserLibrary(userId);

        String response = mockMvc.perform(get("/userGames/users/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(8))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

    @Transactional
    long createUser() throws Exception {
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

        return objectMapper.readTree(userResponse).get("id").asLong();
    }

    @Transactional
    long createGame() throws Exception {
        GameCreateDTO gameCreateDTO = new GameCreateDTO();
        gameCreateDTO.setTitle("Library Test Game");
        gameCreateDTO.setDescription("A test game for library integration");
        gameCreateDTO.setPrice(new BigDecimal("14.99"));
        gameCreateDTO.setReleaseDate(LocalDate.now());
        gameCreateDTO.setDeveloper("Integration Dev");

        String gameResponse = mockMvc.perform(post("/games")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gameCreateDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value("Library Test Game"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        return objectMapper.readTree(gameResponse).get("id").asLong();
    }



    @Transactional
    List<Long> setupUserLibrary(Long userId) throws Exception {
        GameTestSetup gameTestSetup = new GameTestSetup();
        List<GameCreateDTO> createDTOs = gameMapper.toCreateDTOList(gameTestSetup.getGames());
        List<Long> gameIds = new ArrayList<>();
        for (GameCreateDTO createDTO : createDTOs) {
            String response = mockMvc.perform(post("/games")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(createDTO)))
                    .andExpect(status().isCreated())
                    .andReturn()
                    .getResponse()
                    .getContentAsString();

            GameDTO createdGame = objectMapper.readValue(response, GameDTO.class);
            gameIds.add(createdGame.getId());
        }

        for (Long gameId : gameIds) {
            UserGameCreateDTO userGameCreateDTO = new UserGameCreateDTO();
            userGameCreateDTO.setGameId(gameId);

            mockMvc.perform(post("/userGames/users/{id}/games", userId)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(userGameCreateDTO)))
                    .andExpect(status().isCreated());
        }

        return gameIds;
    }

}
