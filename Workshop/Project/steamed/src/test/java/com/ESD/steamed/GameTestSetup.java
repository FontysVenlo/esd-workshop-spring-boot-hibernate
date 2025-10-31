package com.ESD.steamed;
import com.ESD.steamed.game.Game;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class GameTestSetup {

    private final List<Game> games = new ArrayList<>();

    public GameTestSetup() {
        fillGamesList();
    }

    public List<Game> getGames() {
        return games;
    }

    private void fillGamesList() {
        Game cyberPunk = new Game();
        Game baldursGate = new Game();
        Game leagueOfLegends = new Game();
        Game counterStrike = new Game();
        Game eldenRing = new Game();
        Game minecraft = new Game();
        Game gtaV = new Game();
        Game zeldaTOTK = new Game();

        baldursGate.setTitle("Baldur's Gate 3");
        baldursGate.setDescription("Epic party-based RPG with rich storytelling and turn-based combat.");
        baldursGate.setPrice(new BigDecimal("69.99"));
        baldursGate.setReleaseDate(LocalDate.of(2023, 8, 3));
        baldursGate.setDeveloper("Larian Studios");

        cyberPunk.setTitle("Cyberpunk 2077");
        cyberPunk.setDescription("An open-world RPG set in a dystopian futuristic city.");
        cyberPunk.setPrice(new BigDecimal("59.99"));
        cyberPunk.setReleaseDate(LocalDate.of(2020, 12, 10));
        cyberPunk.setDeveloper("CD Projekt Red");

        leagueOfLegends.setTitle("League of Legends");
        leagueOfLegends.setDescription("A competitive 5v5 MOBA where two teams battle to destroy the Nexus.");
        leagueOfLegends.setPrice(BigDecimal.ZERO);
        leagueOfLegends.setReleaseDate(LocalDate.of(2009, 10, 27));
        leagueOfLegends.setDeveloper("Riot Games");

        counterStrike.setTitle("Counter-Strike 2");
        counterStrike.setDescription("Tactical first-person shooter emphasizing team strategy and skill.");
        counterStrike.setPrice(BigDecimal.ZERO);
        counterStrike.setReleaseDate(LocalDate.of(2023, 9, 27));
        counterStrike.setDeveloper("Valve");

        eldenRing.setTitle("Elden Ring");
        eldenRing.setDescription("Open-world action RPG set in the Lands Between, created by FromSoftware.");
        eldenRing.setPrice(new BigDecimal("69.99"));
        eldenRing.setReleaseDate(LocalDate.of(2022, 2, 25));
        eldenRing.setDeveloper("FromSoftware");

        minecraft.setTitle("Minecraft");
        minecraft.setDescription("Sandbox game about placing blocks, exploring worlds, and surviving adventures.");
        minecraft.setPrice(new BigDecimal("26.95"));
        minecraft.setReleaseDate(LocalDate.of(2011, 11, 18));
        minecraft.setDeveloper("Mojang Studios");

        gtaV.setTitle("Grand Theft Auto V");
        gtaV.setDescription("Open-world action-adventure featuring crime, driving, and a sprawling Los Santos.");
        gtaV.setPrice(new BigDecimal("29.99"));
        gtaV.setReleaseDate(LocalDate.of(2013, 9, 17));
        gtaV.setDeveloper("Rockstar Games");

        zeldaTOTK.setTitle("The Legend of Zelda: Tears of the Kingdom");
        zeldaTOTK.setDescription("Epic open-world adventure and sequel to Breath of the Wild.");
        zeldaTOTK.setPrice(new BigDecimal("69.99"));
        zeldaTOTK.setReleaseDate(LocalDate.of(2023, 5, 12));
        zeldaTOTK.setDeveloper("Nintendo");

        games.add(cyberPunk);
        games.add(baldursGate);
        games.add(leagueOfLegends);
        games.add(counterStrike);
        games.add(eldenRing);
        games.add(minecraft);
        games.add(gtaV);
        games.add(zeldaTOTK);
    }
}
