package com.ESD.steamed;

import com.ESD.steamed.game.Game;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class GameTest {

    private List<Game> games;

    @BeforeEach
    public void setup() {
        games = new GameTestSetup().getGames();
    }

    @Test
    void testEntity() {
        SoftAssertions softly = new SoftAssertions();

        Game baldursGate = games.stream()
                .filter(g -> "Baldur's Gate 3".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(baldursGate.getTitle()).isEqualTo("Baldur's Gate 3");
        softly.assertThat(baldursGate.getDescription()).isEqualTo("Epic party-based RPG with rich storytelling and turn-based combat.");
        softly.assertThat(baldursGate.getPrice()).isEqualByComparingTo("69.99");
        softly.assertThat(baldursGate.getReleaseDate()).isBefore(LocalDate.now());
        softly.assertThat(baldursGate.getDeveloper()).isEqualTo("Larian Studios");

        Game cyberpunk = games.stream()
                .filter(g -> "Cyberpunk 2077".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(cyberpunk.getPrice()).isEqualByComparingTo("59.99");
        softly.assertThat(cyberpunk.getDeveloper()).isEqualTo("CD Projekt Red");
        softly.assertThat(cyberpunk.getDescription()).isEqualTo("An open-world RPG set in a dystopian futuristic city.");
        softly.assertThat(cyberpunk.getReleaseDate()).isBefore(LocalDate.now());

        Game lol = games.stream()
                .filter(g -> "League of Legends".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(lol.getPrice()).isEqualByComparingTo("0.00");
        softly.assertThat(lol.getDeveloper()).isEqualTo("Riot Games");
        softly.assertThat(lol.getDescription()).isEqualTo("A competitive 5v5 MOBA where two teams battle to destroy the Nexus.");

        Game cs = games.stream()
                .filter(g -> "Counter-Strike 2".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(cs.getPrice()).isEqualByComparingTo("0.00");
        softly.assertThat(cs.getDeveloper()).isEqualTo("Valve");
        softly.assertThat(cs.getDescription()).isEqualTo("Tactical first-person shooter emphasizing team strategy and skill.");

        Game elden = games.stream()
                .filter(g -> "Elden Ring".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(elden.getPrice()).isEqualByComparingTo("69.99");
        softly.assertThat(elden.getDeveloper()).isEqualTo("FromSoftware");
        softly.assertThat(elden.getDescription()).isEqualTo("Open-world action RPG set in the Lands Between, created by FromSoftware.");

        Game minecraft = games.stream()
                .filter(g -> "Minecraft".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(minecraft.getPrice()).isEqualByComparingTo("26.95");
        softly.assertThat(minecraft.getDeveloper()).isEqualTo("Mojang Studios");
        softly.assertThat(minecraft.getDescription()).isEqualTo("Sandbox game about placing blocks, exploring worlds, and surviving adventures.");

        Game gta = games.stream()
                .filter(g -> "Grand Theft Auto V".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(gta.getPrice()).isEqualByComparingTo("29.99");
        softly.assertThat(gta.getDeveloper()).isEqualTo("Rockstar Games");
        softly.assertThat(gta.getDescription()).isEqualTo("Open-world action-adventure featuring crime, driving, and a sprawling Los Santos.");

        Game zelda = games.stream()
                .filter(g -> "The Legend of Zelda: Tears of the Kingdom".equals(g.getTitle()))
                .findFirst()
                .orElseThrow();
        softly.assertThat(zelda.getPrice()).isEqualByComparingTo("69.99");
        softly.assertThat(zelda.getDeveloper()).isEqualTo("Nintendo");
        softly.assertThat(zelda.getDescription()).isEqualTo("Epic open-world adventure and sequel to Breath of the Wild.");

        softly.assertAll();
    }

}
