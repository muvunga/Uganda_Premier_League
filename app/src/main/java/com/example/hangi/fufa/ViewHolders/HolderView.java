package com.example.hangi.fufa.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangi.fufa.R;
import com.squareup.picasso.Picasso;

import static com.example.hangi.fufa.R.id.TeamA;
import static com.example.hangi.fufa.R.id.TeamB;

/**
 * Created by hangi on 4/2/18.
 */

public class HolderView  extends RecyclerView.ViewHolder{
    public View mview;
    public HolderView(View itemView) {
        super(itemView);
        mview=itemView;
    }

    public void setTeamA(Context context,String teamA) {

        ImageView mteamA=itemView.findViewById(R.id.TeamA);
        Picasso.with(context).load(teamA).into(mteamA);

    }

    public void setTeamB(Context context,String teamB) {
        ImageView mteamB=itemView.findViewById(R.id.TeamB);
        Picasso.with(context).load(teamB).into(mteamB);

    }

    public void setGameTime(String GameTime) {
        TextView mDateGame=itemView.findViewById(R.id.getTime);
        mDateGame.setText(GameTime);

    }
}
