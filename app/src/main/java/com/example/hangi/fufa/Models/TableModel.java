package com.example.hangi.fufa.Models;

/**
 * Created by hangi on 4/15/18.
 */

public class TableModel  {

    private String teamNames;
    private String teamsPoints;

    public TableModel(){

    }


    public TableModel(String teamNames, String teamsPoints) {
        this.teamNames = teamNames;
        this.teamsPoints = teamsPoints;
    }

    public String getTeamNames() {
        return teamNames;
    }

    public void setTeamNames(String teamNames) {
        this.teamNames = teamNames;
    }

    public String getTeamsPoints() {
        return teamsPoints;
    }

    public void setTeamsPoints(String teamsPoints) {
        this.teamsPoints = teamsPoints;
    }
}
