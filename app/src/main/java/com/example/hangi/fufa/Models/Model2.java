package com.example.hangi.fufa.Models;

import static com.example.hangi.fufa.R.id.TeamA;
import static com.example.hangi.fufa.R.id.TeamB;

/**
 * Created by hangi on 4/2/18.
 */

public class Model2 {
    private String TeamA,TeamB,GameTime;

    public Model2(){

    }

    public Model2(String teamA, String teamB, String gameTime) {
        this.TeamA = teamA;
        this.TeamB = teamB;
        this.GameTime = gameTime;
    }

    public String getTeamA() {
        return TeamA;
    }

    public void setTeamA(String teamA) {
        TeamA = teamA;
    }

    public String getTeamB() {
        return TeamB;
    }

    public void setTeamB(String teamB) {
        TeamB = teamB;
    }

    public String getGameTime() {
        return GameTime;
    }

    public void setGameTime(String gameTime) {
        GameTime = gameTime;
    }
}
