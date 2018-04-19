package com.example.hangi.fufa.Models;

/**
 * Created by hangi on 4/1/18.
 */

public class PlayerModel {
    private String playerName;
    private String PlayerTeam;
    private String playerPhoto;
    private Long Assist;
    private Long Goals;
    private Long Games;
    private String position;
    private String biography,Minutes;

    public PlayerModel() {
    }

    public PlayerModel(String playerName, String playerTeam, String playerPhoto,String Minutes,Long games, Long assist, Long goals,String position,String biography) {
        this.playerName = playerName;
        this.PlayerTeam = playerTeam;
        this.playerPhoto = playerPhoto;
        this.Games = games;
        this.Assist = assist;
        this.Goals = goals;
        this.position=position;
        this.biography=biography;
        this.Minutes=Minutes;
    }



    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerTeam() {
        return PlayerTeam;
    }

    public void setPlayerTeam(String playerTeam) {
        PlayerTeam = playerTeam;
    }

    public String getPlayerPhoto() {
        return playerPhoto;
    }

    public void setPlayerPhoto(String playerPhoto) {
        this.playerPhoto = playerPhoto;
    }

    public Long getGames() {
        return Games;
    }

    public void setGames(Long games) {
        this.Games = games;
    }

    public Long getAssist() {
        return Assist;
    }

    public void setAssist(Long assist) {
        this.Assist = assist;
    }

    public Long getGoals() {
        return Goals;
    }

    public void setGoals(Long goals) {
        this.Goals = goals;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getMinutes() {
        return Minutes;
    }

    public void setMinutes(String minutes) {
        Minutes = minutes;
    }
}
