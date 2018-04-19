package com.example.hangi.fufa.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangi.fufa.R;
import com.squareup.picasso.Picasso;

import static com.example.hangi.fufa.R.id.Minutes;

/**
 * Created by hangi on 4/1/18.
 */

public class PLayerViewHolder extends RecyclerView.ViewHolder {

    public View view;

    public PLayerViewHolder(View itemView) {
        super(itemView);
        view = itemView;
    }



    public void setPlayerName(String playerName){
        TextView mName = itemView.findViewById(R.id.nAMEpLAYER);
        mName.setText(playerName);
    }


    public void setPlayerTeam(String playerTeam){
        TextView mTeam = itemView.findViewById(R.id.TeamText);
        mTeam.setText(playerTeam);
    }



    public void setPlayerPhoto(Context context,String playerPhoto) {
        ImageView mPhoto = itemView.findViewById(R.id.PlayerProfil);
        Picasso.with(context).load(playerPhoto).into(mPhoto);
    }



    public void setAssist(String assist) {
       TextView Assist=itemView.findViewById(R.id.MatchJ);
        Assist.setText(assist);
    }

    public void setGoals(String goals) {
        TextView Mgoal=itemView.findViewById(R.id.GoalTitle);
        Mgoal.setText(goals);
    }

    public void setGames(String games) {
       TextView gam=itemView.findViewById(R.id.Match);
        gam.setText(games);
    }

    public void setMinutes(String minutes) {
        TextView minutesPLayed=itemView.findViewById(R.id.Minutes);
                minutesPLayed.setText(minutes);
    }

    public void setPosition(String position) {
       TextView post=itemView.findViewById(R.id.position);
        post.setText(position);
    }

    public void setBiography(String biography) {
        TextView story=itemView.findViewById(R.id.contentBio);
        story.setText(biography);
    }



}
