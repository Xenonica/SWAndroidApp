package com.example.joshu.fyp;

public class IPPT {

    int situp, pushup, points;
    String runningtime, award, name;

    public IPPT(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IPPT(String name, int situp, int pushup, String runningtime, int points, String award) {
        this.name = name;
        this.situp = situp;
        this.pushup = pushup;
        this.points = points;
        this.award = award;
        this.runningtime = runningtime;
    }

    public int getSitup() {
        return situp;
    }

    public void setSitup(int situp) {
        this.situp = situp;
    }

    public int getPushup() {
        return pushup;
    }

    public void setPushup(int pushup) {
        this.pushup = pushup;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getRunningtime() {
        return runningtime;
    }

    public void setRunningtime(String runningtime) {
        this.runningtime = runningtime;
    }
}

