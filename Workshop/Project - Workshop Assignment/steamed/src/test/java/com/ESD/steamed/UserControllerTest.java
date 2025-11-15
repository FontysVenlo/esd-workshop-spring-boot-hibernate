package com.ESD.steamed;

import com.ESD.steamed.game.GameCreateDTO;
import com.ESD.steamed.user.UserCreateDTO;
import com.ESD.steamed.userGame.UserGameCreateDTO;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    void testAddUser() throws Exception {

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
    }

    @Test
    @Transactional
    void testGetUser() throws Exception {

        UserCreateDTO userCreateDTO = new UserCreateDTO("TestUser","testuser@example.com","securePassword");

        String userPostResponse = mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(userCreateDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("TestUser"))
                .andExpect(jsonPath("$.email").value("testuser@example.com"))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Long userId = objectMapper.readTree(userPostResponse).get("id").asLong();

        mockMvc.perform(get("/users/{id}", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(userId))
                .andExpect(jsonPath("$.username").value("TestUser"))
                .andExpect(jsonPath("$.email").value("testuser@example.com"));
    }

}
