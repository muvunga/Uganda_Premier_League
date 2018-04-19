package com.example.hangi.fufa.Models;

/**
 * Created by hangi on 4/1/18.
 */

public class Model {
    public String newstitle, newscontent, img;


    public Model() {
    }

    public Model(String newstitle, String newscontent, String img) {
        this.newstitle = newstitle;
        this.newscontent = newscontent;
        this.img = img;

    }



    public String getNewstitle() {
        return newstitle;
    }

    public void setNewstitle(String newstitle) {
        this.newstitle = newstitle;
    }

    public String getNewscontent() {
        return newscontent;
    }

    public void setNewscontent(String newscontent) {
        this.newscontent = newscontent;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


    //Getters and Setters for fixtures

//    public String getTeamA() {
//        return TeamA;
//    }
//
//    public void setTeamA(String teamA) {
//        this.TeamA = teamA;
//    }
//
//    public String getTeamB() {
//        return TeamB;
//    }
//
//    public void setTeamB(String teamB) {
//        this.TeamB = teamB;
//    }
//
//    public String getGameTime() {
//        return GameTime;
//    }
//
//    public void setGameTime(String gameTime) {
//        this.GameTime = gameTime;
//    }
}
