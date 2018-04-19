package com.example.hangi.fufa.Models;

/**
 * Created by hangi on 4/8/18.
 */

public class ResultModel {


    private String TEAMA,TEAMB,RESULT,teamPhoto1,teamphoto2;
    public ResultModel(){

    }

    public ResultModel(String TEAMA, String TEAMB, String RESULT,String teamPhoto1,String teamphoto2) {
        this.TEAMA = TEAMA;
        this.TEAMB = TEAMB;
        this.RESULT = RESULT;
        this.teamPhoto1=teamPhoto1;
        this.teamphoto2=teamphoto2;
    }

    public String getTEAMA() {
        return TEAMA;
    }

    public void setTEAMA(String TEAMA) {
        this.TEAMA = TEAMA;
    }

    public String getTEAMB() {
        return TEAMB;
    }

    public void setTEAMB(String TEAMB) {
        this.TEAMB = TEAMB;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getTeamPhoto1() {
        return teamPhoto1;
    }

    public void setTeamPhoto1(String teamPhoto1) {
        this.teamPhoto1 = teamPhoto1;
    }

    public String getTeamphoto2() {
        return teamphoto2;
    }

    public void setTeamphoto2(String teamphoto2) {
        this.teamphoto2 = teamphoto2;
    }
}
