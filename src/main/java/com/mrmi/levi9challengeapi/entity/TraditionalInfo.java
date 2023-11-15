package com.mrmi.levi9challengeapi.entity;

public class TraditionalInfo {
    private ThrowInfo freeThrows;
    private ThrowInfo twoPoints;
    private ThrowInfo threePoints;
    private double points;
    private double rebounds;
    private double blocks;
    private double assists;
    private double steals;
    private double turnovers;

    public TraditionalInfo(ThrowInfo freeThrows, ThrowInfo twoPoints, ThrowInfo threePoints, double points, double rebounds, double blocks, double assists, double steals, double turnovers) {
        this.freeThrows = freeThrows;
        this.twoPoints = twoPoints;
        this.threePoints = threePoints;
        this.points = points;
        this.rebounds = rebounds;
        this.blocks = blocks;
        this.assists = assists;
        this.steals = steals;
        this.turnovers = turnovers;
    }

    public ThrowInfo getFreeThrows() {
        return freeThrows;
    }

    public void setFreeThrows(ThrowInfo freeThrows) {
        this.freeThrows = freeThrows;
    }

    public ThrowInfo getTwoPoints() {
        return twoPoints;
    }

    public void setTwoPoints(ThrowInfo twoPoints) {
        this.twoPoints = twoPoints;
    }

    public ThrowInfo getThreePoints() {
        return threePoints;
    }

    public void setThreePoints(ThrowInfo threePoints) {
        this.threePoints = threePoints;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getRebounds() {
        return rebounds;
    }

    public void setRebounds(double rebounds) {
        this.rebounds = rebounds;
    }

    public double getBlocks() {
        return blocks;
    }

    public void setBlocks(double blocks) {
        this.blocks = blocks;
    }

    public double getAssists() {
        return assists;
    }

    public void setAssists(double assists) {
        this.assists = assists;
    }

    public double getSteals() {
        return steals;
    }

    public void setSteals(double steals) {
        this.steals = steals;
    }

    public double getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(double turnovers) {
        this.turnovers = turnovers;
    }
}
