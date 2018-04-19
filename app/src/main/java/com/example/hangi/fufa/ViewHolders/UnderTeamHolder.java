package com.example.hangi.fufa.ViewHolders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangi.fufa.R;
import com.squareup.picasso.Picasso;

/**
 * Created by hangi on 4/10/18.
 */

public class UnderTeamHolder extends RecyclerView.ViewHolder {

    public View view;

    public UnderTeamHolder(View itemView) {
        super(itemView);
        view=itemView;
    }



    public void setPlayerName(String playerName){
        TextView mName = itemView.findViewById(R.id.namesPlayer);
        mName.setText(playerName);
    }

    public void setPlayerPhoto(Context context, String playerPhoto) {
        ImageView mPhoto = itemView.findViewById(R.id.playerUnderTeam);
        Picasso.with(context).load(playerPhoto).into(mPhoto);
    }

    public void setPosition(String position) {
        TextView post=itemView.findViewById(R.id.PositPlayer);
        post.setText(position);
    }
}
