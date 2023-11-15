package com.mrmi.levi9challengeapi.repository;

import com.mrmi.levi9challengeapi.entity.PlayerInfo;

public interface IPlayerInfoRepository {
    PlayerInfo getPlayerInfoByName(String name);
}
