package com.mrmi.levi9challengeapi.entity;

public class AdvancedInfo {
    private double valorization;
    private double effectiveFieldGoalPercentage;
    private double trueShootingPercentage;
    private double hollingerAssistRatio;

    public AdvancedInfo(double valorization, double effectiveFieldGoalPercentage, double trueShootingPercentage, double hollingerAssistRatio) {
        this.valorization = valorization;
        this.effectiveFieldGoalPercentage = effectiveFieldGoalPercentage;
        this.trueShootingPercentage = trueShootingPercentage;
        this.hollingerAssistRatio = hollingerAssistRatio;
    }

    public double getValorization() {
        return valorization;
    }

    public void setValorization(double valorization) {
        this.valorization = valorization;
    }

    public double getEffectiveFieldGoalPercentage() {
        return effectiveFieldGoalPercentage;
    }

    public void setEffectiveFieldGoalPercentage(double effectiveFieldGoalPercentage) {
        this.effectiveFieldGoalPercentage = effectiveFieldGoalPercentage;
    }

    public double getTrueShootingPercentage() {
        return trueShootingPercentage;
    }

    public void setTrueShootingPercentage(double trueShootingPercentage) {
        this.trueShootingPercentage = trueShootingPercentage;
    }

    public double getHollingerAssistRatio() {
        return hollingerAssistRatio;
    }

    public void setHollingerAssistRatio(double hollingerAssistRatio) {
        this.hollingerAssistRatio = hollingerAssistRatio;
    }
}