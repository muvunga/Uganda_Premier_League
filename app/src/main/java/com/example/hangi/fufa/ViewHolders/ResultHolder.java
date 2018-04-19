package com.example.hangi.fufa.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangi.fufa.R;
import com.squareup.picasso.Picasso;

/**
 * Created by hangi on 4/8/18.
 */

public class ResultHolder extends RecyclerView.ViewHolder {

    public View view;

    public ResultHolder(View itemView) {
        super(itemView);
    }

    public void setTEAMA(String TEAMA) {
        TextView teamA=itemView.findViewById(R.id.DayTeam);
        teamA.setText(TEAMA);
    }

    public void setTEAMB(String TEAMB) {
        TextView teamB=itemView.findViewById(R.id.DayTeam2);
        teamB.setText(TEAMB);
    }

    public void setRESULT(String RESULT) {
       TextView result=itemView.findViewById(R.id.DayScore);
        result.setText(RESULT);
    }


    public void setTeamPhoto1(Context context, String teamPhoto1) {
        ImageView photo = itemView.findViewById(R.id.resultPhoto);
        Picasso.with(context).load(teamPhoto1).into(photo);
    }

    public void setTeamphoto2(Context context,String teamphoto2) {

        ImageView photo2=itemView.findViewById(R.id.resultPhoto2);
        Picasso.with(context).load(teamphoto2).into(photo2);

    }
}
