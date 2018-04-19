package com.example.hangi.fufa.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangi.fufa.R;
import com.squareup.picasso.Picasso;

import static android.R.attr.id;
import static android.R.attr.itemBackground;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


/**
 * Created by hangi on 4/7/18.
 */

public class TeamHolder  extends RecyclerView.ViewHolder{
    public View mview;


    public TeamHolder(View itemView) {
        super(itemView);
        mview=itemView;
    }
    public void setTeamName(String TeamName) {
        TextView mTeam = itemView.findViewById(R.id.TEAMSname);
        mTeam.setText(TeamName);
    }

    public void setManager(String Manager) {

        TextView ktex=itemView.findViewById(R.id.Managedby);
        ktex.setText(Manager);

    }

    public void setTeamPhoto(Context context,String TeamPhoto) {
        ImageView mPhoto = itemView.findViewById(R.id.imageTeam);
        Picasso.with(context).load(TeamPhoto).into(mPhoto);
    }

    public void setGamePlayed(String GamePlayed) {
        TextView ga=itemView.findViewById(R.id.Gameplayed);
        //ga.getLong(GamePlayed);
        ga.setText(GamePlayed);
    }

    public void setGamesWon(String gamesWon) {
        TextView games=itemView.findViewById(R.id.WG);
        games.setText(gamesWon);
    }

    public void setGamesLost(String gamesLost) {

        TextView lost=itemView.findViewById(R.id.LGM);
        lost.setText(gamesLost);
    }

    public void setDraws(String draws) {
    TextView draw=itemView.findViewById(R.id.dG);
        draw.setText(draws);
    }

    public void setHistory(String history) {
        TextView hist=itemView.findViewById(R.id.ClubHistory);
        hist.setText(history);
    }




}
