package com.mrmi.levi9challengeapi.service;

import com.mrmi.levi9challengeapi.entity.PlayerInfo;
import com.mrmi.levi9challengeapi.repository.IPlayerInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerInfoService {
    private final IPlayerInfoRepository playerInfoRepository;

    @Autowired
    public PlayerInfoService(IPlayerInfoRepository playerInfoRepository) {
        this.playerInfoRepository = playerInfoRepository;
    }

    public PlayerInfo getPlayerInfoByName(String name) {
        return playerInfoRepository.getPlayerInfoByName(name);
    }
}