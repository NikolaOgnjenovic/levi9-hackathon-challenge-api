package com.mrmi.levi9challengeapi.repository;

import com.mrmi.levi9challengeapi.entity.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

@Repository
public class PlayerInfoRepository implements IPlayerInfoRepository {
    private HashMap<String, PlayerInfo> playerInfoMap = new HashMap<>();
    private static String CSV_FILE_PATH = "static/player_data.csv";

    public PlayerInfoRepository() {
        playerInfoMap = new HashMap<>();
        readCSV();
    }

    public PlayerInfo getPlayerInfoByName(String name) {
        return playerInfoMap.get(name);
    }

    public void populateMap(String[][] rowDataList) {
        for (String[] rowData : rowDataList) {
            updatePlayerInfo(rowData);
        }
    }

    private void readCSV() {
        Resource resource = new ClassPathResource(CSV_FILE_PATH);

        try (CSVReader reader = new CSVReader(new FileReader(resource.getFile()))) {
            reader.readNext(); // Skip the header

            String[] rowData;
            while ((rowData = reader.readNext()) != null) {
                updatePlayerInfo(rowData);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }

    private void updatePlayerInfo(String[] rowData) {
        String name = rowData[0];
        double FTM = Double.parseDouble(rowData[2]);
        double FTA = Double.parseDouble(rowData[3]);
        double twoPM = Double.parseDouble(rowData[4]);
        double twoPA = Double.parseDouble(rowData[5]);
        double threePM = Double.parseDouble(rowData[6]);
        double threePA = Double.parseDouble(rowData[7]);
        double PTS = FTM + 2 * twoPM + 3 * threePM;
        double REB = Double.parseDouble(rowData[8]);
        double BLK = Double.parseDouble(rowData[9]);
        double AST = Double.parseDouble(rowData[10]);
        double STL = Double.parseDouble(rowData[11]);
        double TOV = Double.parseDouble(rowData[12]);

        if (playerInfoMap.containsKey(name)) {
            updateExistingPlayerInfo(name, FTA, FTM, twoPA, twoPM, threePA, threePM, PTS, REB, BLK, AST, STL, TOV);
        } else {
            playerInfoMap.put(name, createNewPlayerInfo(name, FTA, FTM, twoPA, twoPM, threePA, threePM, PTS, REB, BLK, AST, STL, TOV));
        }
    }

    private void updateExistingPlayerInfo(String name, double FTA, double FTM, double twoPA, double twoPM, double threePA, double threePM, double PTS, double REB, double BLK, double AST, double STL, double TOV) {
        PlayerInfo playerInfo = playerInfoMap.get(name);
        playerInfo.setGamesPlayed(playerInfo.getGamesPlayed() + 1);

        TraditionalInfo traditionalInfo = playerInfo.getTraditional();
        traditionalInfo.getFreeThrows().setAttempts((traditionalInfo.getFreeThrows().getAttempts() * (playerInfo.getGamesPlayed() - 1) + FTA) / playerInfo.getGamesPlayed());
        traditionalInfo.getFreeThrows().setMade((traditionalInfo.getFreeThrows().getMade() * (playerInfo.getGamesPlayed() - 1) + FTM) / playerInfo.getGamesPlayed());
        traditionalInfo.getTwoPoints().setAttempts((traditionalInfo.getTwoPoints().getAttempts() * (playerInfo.getGamesPlayed() - 1) + twoPA) / playerInfo.getGamesPlayed());
        traditionalInfo.getTwoPoints().setMade((traditionalInfo.getTwoPoints().getMade() * (playerInfo.getGamesPlayed() - 1) + twoPM) / playerInfo.getGamesPlayed());
        traditionalInfo.getThreePoints().setAttempts((traditionalInfo.getThreePoints().getAttempts() * (playerInfo.getGamesPlayed() - 1) + threePA) / playerInfo.getGamesPlayed());
        traditionalInfo.getThreePoints().setMade((traditionalInfo.getThreePoints().getMade() * (playerInfo.getGamesPlayed() - 1) + threePM) / playerInfo.getGamesPlayed());
        traditionalInfo.setPoints((traditionalInfo.getPoints() * (playerInfo.getGamesPlayed() - 1) + PTS) / playerInfo.getGamesPlayed());
        traditionalInfo.setRebounds((traditionalInfo.getRebounds() * (playerInfo.getGamesPlayed() - 1) + REB) / playerInfo.getGamesPlayed());
        traditionalInfo.setBlocks((traditionalInfo.getBlocks() * (playerInfo.getGamesPlayed() - 1) + BLK) / playerInfo.getGamesPlayed());
        traditionalInfo.setAssists((traditionalInfo.getAssists() * (playerInfo.getGamesPlayed() - 1) + AST) / playerInfo.getGamesPlayed());
        traditionalInfo.setSteals((traditionalInfo.getSteals() * (playerInfo.getGamesPlayed() - 1) + STL) / playerInfo.getGamesPlayed());
        traditionalInfo.setTurnovers((traditionalInfo.getTurnovers() * (playerInfo.getGamesPlayed() - 1) + TOV) / playerInfo.getGamesPlayed());

        AdvancedInfo advancedInfo = playerInfo.getAdvanced();
        advancedInfo.setValorization((advancedInfo.getValorization() * (playerInfo.getGamesPlayed() - 1) + (FTM + 2 * twoPM + 3 * threePM + REB + BLK + AST + STL) - (FTA - FTM + twoPA - twoPM + threePA - threePM + TOV) ) / playerInfo.getGamesPlayed());
        advancedInfo.setEffectiveFieldGoalPercentage((advancedInfo.getEffectiveFieldGoalPercentage() * (playerInfo.getGamesPlayed() - 1) + (twoPM + threePM + 0.5 * threePM) / (twoPA + threePA) * 100) / playerInfo.getGamesPlayed());
        advancedInfo.setTrueShootingPercentage((advancedInfo.getTrueShootingPercentage() * (playerInfo.getGamesPlayed() - 1) + (PTS / (2 * (twoPA + threePA + 0.475 * FTA)) * 100)) / playerInfo.getGamesPlayed());
        advancedInfo.setHollingerAssistRatio((advancedInfo.getHollingerAssistRatio() * (playerInfo.getGamesPlayed() - 1) + (AST / (twoPA + threePA + 0.475 * FTA + AST + TOV) * 100)) / playerInfo.getGamesPlayed());
    }

    private PlayerInfo createNewPlayerInfo(String name, double FTA, double FTM, double twoPA, double twoPM, double threePA, double threePM, double PTS, double REB, double BLK, double AST, double STL, double TOV) {
        return new PlayerInfo(name, 1, new TraditionalInfo(new ThrowInfo(FTA, FTM), new ThrowInfo(twoPA, twoPM), new ThrowInfo(threePA, threePM), PTS, REB, BLK, AST, STL, TOV), new AdvancedInfo(
                (FTM + 2 * twoPM + 3 * threePM + REB + BLK + AST + STL) - (FTA - FTM + twoPA - twoPM + threePA - threePM + TOV),
                (twoPM + threePM + 0.5 * threePM) / (twoPA + threePA) * 100,
                (PTS / (2 * (twoPA + threePA + 0.475 * FTA)) * 100),
                (AST / (twoPA + threePA + 0.475 * FTA + AST + TOV) * 100)));
    }
}
