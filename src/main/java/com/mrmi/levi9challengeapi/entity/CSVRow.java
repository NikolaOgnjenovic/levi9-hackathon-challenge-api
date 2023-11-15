package com.mrmi.levi9challengeapi.entity;

public class CSVRow {
    private String player;
    private String position;
    private double FTM;
    private double FTA;
    private double twoPM;
    private double twoPA;
    private double threePM;
    private double threePA;
    private double REB;
    private double BLK;
    private double AST;
    private double STL;
    private double TOL;

    public CSVRow(String player, String position, double FTM, double FTA, double twoPM, double twoPA, double threePM, double threePA, double REB, double BLK, double AST, double STL, double TOL) {
        this.player = player;
        this.position = position;
        this.FTM = FTM;
        this.FTA = FTA;
        this.twoPM = twoPM;
        this.twoPA = twoPA;
        this.threePM = threePM;
        this.threePA = threePA;
        this.REB = REB;
        this.BLK = BLK;
        this.AST = AST;
        this.STL = STL;
        this.TOL = TOL;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getFTM() {
        return FTM;
    }

    public void setFTM(double FTM) {
        this.FTM = FTM;
    }

    public double getFTA() {
        return FTA;
    }

    public void setFTA(double FTA) {
        this.FTA = FTA;
    }

    public double getTwoPM() {
        return twoPM;
    }

    public void setTwoPM(double twoPM) {
        this.twoPM = twoPM;
    }

    public double getTwoPA() {
        return twoPA;
    }

    public void setTwoPA(double twoPA) {
        this.twoPA = twoPA;
    }

    public double getThreePM() {
        return threePM;
    }

    public void setThreePM(double threePM) {
        this.threePM = threePM;
    }

    public double getThreePA() {
        return threePA;
    }

    public void setThreePA(double threePA) {
        this.threePA = threePA;
    }

    public double getREB() {
        return REB;
    }

    public void setREB(double REB) {
        this.REB = REB;
    }

    public double getBLK() {
        return BLK;
    }

    public void setBLK(double BLK) {
        this.BLK = BLK;
    }

    public double getAST() {
        return AST;
    }

    public void setAST(double AST) {
        this.AST = AST;
    }

    public double getSTL() {
        return STL;
    }

    public void setSTL(double STL) {
        this.STL = STL;
    }

    public double getTOL() {
        return TOL;
    }

    public void setTOL(double TOL) {
        this.TOL = TOL;
    }
}
