package com.example.hangi.fufa.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hangi.fufa.R;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by hangi on 4/15/18.
 */

public class TableHolder extends RecyclerView.ViewHolder {
    public TableHolder(View itemView) {
        super(itemView);
    }

    public void setTeamNames(String teamNames) {
       TextView textTeam=itemView.findViewById(R.id.teamTable);
        textTeam.setText(teamNames);
    }

    public void setTeamsPoints(String teamsPoints) {
       TextView points=itemView.findViewById(R.id.teamMarks);
        points.setText(teamsPoints);
    }

}
