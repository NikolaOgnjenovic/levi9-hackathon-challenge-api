package com.mrmi.levi9challengeapi.entity;

public class ThrowInfo {
    private double attempts;
    private double made;
    private double shootingPercentage;

    public ThrowInfo(double attempts, double made) {
        this.attempts = attempts;
        this.made = made;
        updateShootingPercentage();
    }

    public double getAttempts() {
        return attempts;
    }

    public void setAttempts(double attempts) {
        this.attempts = attempts;
        updateShootingPercentage();
    }

    public double getMade() {
        return made;
    }

    public void setMade(double made) {
        this.made = made;
        updateShootingPercentage();
    }

    public double getShootingPercentage() {
        return shootingPercentage;
    }

    private void updateShootingPercentage() {
        if (attempts != 0) {
            this.shootingPercentage = (made / attempts) * 100;
        } else {
            // Handle the case where attempts are 0 to avoid division by zero
            this.shootingPercentage = 0.0;
        }
    }

    public void setShootingPercentage(double shootingPercentage) {
        this.shootingPercentage = shootingPercentage;
    }
}
