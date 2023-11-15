package com.mrmi.levi9challengeapi.controller;

import com.mrmi.levi9challengeapi.entity.PlayerInfo;
import com.mrmi.levi9challengeapi.service.PlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats/players")
public class PlayerInfoController {
    private final PlayerInfoService playerInfoService;

    @Autowired
    public PlayerInfoController(PlayerInfoService playerInfoService) {
        this.playerInfoService = playerInfoService;
    }

    @GetMapping("/{fullPlayerInfoName}")
    public ResponseEntity<PlayerInfo> getPlayerInfoStats(@PathVariable String fullPlayerInfoName) {
        PlayerInfo playerInfo = playerInfoService.getPlayerInfoByName(fullPlayerInfoName);

        if (playerInfo != null) {
            return ResponseEntity.ok(playerInfo);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
