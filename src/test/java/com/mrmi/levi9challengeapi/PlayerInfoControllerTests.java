package com.mrmi.levi9challengeapi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.mrmi.levi9challengeapi.controller.PlayerInfoController;
import com.mrmi.levi9challengeapi.entity.PlayerInfo;
import com.mrmi.levi9challengeapi.repository.PlayerInfoRepository;
import com.mrmi.levi9challengeapi.service.PlayerInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;


class PlayerInfoControllerTests {
    private PlayerInfoController playerInfoController;

    @BeforeEach
    void setUp() {
        PlayerInfoRepository playerInfoRepository = new PlayerInfoRepository(); // TODO: mock with fake data
        PlayerInfoService playerInfoService = new PlayerInfoService(playerInfoRepository);

        playerInfoController = new PlayerInfoController(playerInfoService);
    }

    @Test
    void testPlayerExists() {
        String playerName = "Sifiso Abdalla";

        ResponseEntity<PlayerInfo> responseEntity = playerInfoController.getPlayerInfoStats(playerName);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCode().value());

        PlayerInfo playerInfo = responseEntity.getBody();
        assertNotNull(playerInfo);
        assertEquals(playerName, playerInfo.getPlayerName());
    }

    @Test
    void testPlayerDoesNotExist() {
        String playerName = "Mrmi";

        ResponseEntity<PlayerInfo> responseEntity = playerInfoController.getPlayerInfoStats(playerName);

        assertNotNull(responseEntity);
        assertEquals(404, responseEntity.getStatusCode().value());
    }

    @Test
    void testExistingPlayerTraditionalDataValid() {
        String playerName = "Sifiso Abdalla";

        ResponseEntity<PlayerInfo> responseEntity = playerInfoController.getPlayerInfoStats(playerName);
        PlayerInfo playerInfo = responseEntity.getBody();
        assertNotNull(playerInfo);
        assertEquals(playerName, playerInfo.getPlayerName());
        assertEquals(3, playerInfo.getGamesPlayed());

        // Advanced data is not tested because I am not sure whether the given test case data in the pdf is correct
        assertEquals(12.3, round(playerInfo.getTraditional().getPoints()));
        assertEquals(5.7, round(playerInfo.getTraditional().getRebounds()));
        assertEquals(1.7, round(playerInfo.getTraditional().getBlocks()));
        assertEquals(0.7, round(playerInfo.getTraditional().getAssists()));
        assertEquals(1.0, round(playerInfo.getTraditional().getSteals()));
        assertEquals(1.3, round(playerInfo.getTraditional().getTurnovers()));
    }

    private double round(double val) {
        return Math.round(val * 10.0) / 10.0;
    }
}