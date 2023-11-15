package com.mrmi.levi9challengeapi.entity;

public class PlayerInfo {
    private String playerName;
    private int gamesPlayed;
    private TraditionalInfo traditional;
    private AdvancedInfo advanced;

    public PlayerInfo(String playerName, int gamesPlayed, TraditionalInfo traditional, AdvancedInfo advanced) {
        this.playerName = playerName;
        this.gamesPlayed = gamesPlayed;
        this.traditional = traditional;
        this.advanced = advanced;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public TraditionalInfo getTraditional() {
        return traditional;
    }

    public void setTraditional(TraditionalInfo traditional) {
        this.traditional = traditional;
    }

    public AdvancedInfo getAdvanced() {
        return advanced;
    }

    public void setAdvanced(AdvancedInfo advanced) {
        this.advanced = advanced;
    }
}
