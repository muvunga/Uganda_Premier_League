package com.example.hangi.fufa.Models;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
//import static com.example.hangi.fufa.R.id.Draw;
import static com.example.hangi.fufa.R.id.Lost;
import static com.example.hangi.fufa.R.id.TeamName;

/**
 * Created by hangi on 4/1/18.
 */

public class TeamModel {
    private String TeamName,Manager, TeamPhoto,History;
    private Long GamePlayed,GamesWon,GamesLost,Draws;



    public TeamModel() {
    }

    public TeamModel(String TeamName, String Manager, String TeamPhoto, Long GamePlayed,Long GamesWon,String History) {
        this.TeamName = TeamName;
        this.Manager = Manager;
        this.TeamPhoto = TeamPhoto;
        this.GamePlayed=GamePlayed;
        this.GamesWon=GamesWon;
        this.History=History;
    }


    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String TeamName) {
        this.TeamName = TeamName;
    }

    public String getManager() {
        return Manager;
    }

    public void setManager(String Manager) {
        this.Manager = Manager;
    }

    public String getTeamPhoto() {
        return TeamPhoto;
    }

    public void setTeamPhoto(String TeamPhoto) {
        this.TeamPhoto = TeamPhoto;
    }

    public Long getGamePlayed() {
        return GamePlayed;
    }

    public void setGamePlayed(Long GamePlayed) {
        this.GamePlayed = GamePlayed;
    }

    public Long getGamesWon() {
        return GamesWon;
    }

    public void setGamesWon(Long gamesWon) {
        GamesWon = gamesWon;
    }

    public Long getGamesLost() {
        return GamesLost;
    }

    public void setGamesLost(Long gamesLost) {
        GamesLost = gamesLost;
    }

    public Long getDraws() {
        return Draws;
    }

    public void setDraws(Long draws) {
        Draws = draws;
    }

    public String getHistory() {
        return History;
    }

    public void setHistory(String history) {
        History = history;
    }
}

