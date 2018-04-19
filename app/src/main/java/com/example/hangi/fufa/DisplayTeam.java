package com.example.hangi.fufa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangi.fufa.Models.Model2;
import com.example.hangi.fufa.Models.PlayerModel;
import com.example.hangi.fufa.ViewHolders.HolderView;
import com.example.hangi.fufa.ViewHolders.UnderTeamHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static com.example.hangi.fufa.R.id.Won;

/**
 * Created by hangi on 4/9/18.
 */
public class DisplayTeam extends AppCompatActivity {
    private DatabaseReference databaseReference;

    private TextView Tname,Games,WIN,LOST,DRAW,TManager,Histor;
    private ImageView profile;
    private static final String TAG="DisplayPlayerStat";
    private DatabaseReference mdatabase;
    private RecyclerView mRecyclerview;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club_stat);


        String _id = getIntent().getExtras().getString("teamsid");

        Log.d(TAG, "onCreate: onCreate: Started");
        databaseReference= FirebaseDatabase.getInstance().getReference().child("teams");

        profile=(ImageView)findViewById(R.id.teamLogo);

        Tname=(TextView)findViewById(R.id.TeamName);

        Games=(TextView)findViewById(R.id.numberofGP);
        WIN=(TextView)findViewById(R.id.Scored);
        LOST=(TextView)findViewById(R.id.Conceded);
         Histor=(TextView)findViewById(R.id.ClubHistory);
        DRAW=(TextView)findViewById(Won);
        TManager=(TextView)findViewById(R.id.Lost);
//getting the table in the database

        mdatabase = FirebaseDatabase.getInstance().getReference().child("players").child(_id);
        mRecyclerview = (RecyclerView) findViewById(R.id.underteamRecyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        Log.w("test",_id);

        mRecyclerview.setLayoutManager(layoutManager);


        databaseReference.child(_id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                String Photo= String.valueOf(dataSnapshot.child("TeamPhoto").getValue());
                String  Win=String.valueOf(dataSnapshot.child("GamesWon").getValue());
                String Manag=String.valueOf(dataSnapshot.child("Manager").getValue());
                String Lost=String.valueOf(dataSnapshot.child("GamesLost").getValue());
                String Draw=String.valueOf(dataSnapshot.child("Draws").getValue());
                String  Game=String.valueOf(dataSnapshot.child("GamePlayed").getValue());
                String team=String.valueOf(dataSnapshot.child("TeamName").getValue());
                String story=String.valueOf(dataSnapshot.child("History").getValue());

                Picasso.with(DisplayTeam.this).load(Photo).into(profile);
                WIN.setText(Win);
                Tname.setText(team);
                LOST.setText(Lost);
                TManager.setText(Manag);
                Games.setText(Game);
                DRAW.setText(Draw);
                Histor.setText(story);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<PlayerModel,UnderTeamHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<PlayerModel, UnderTeamHolder>(
                PlayerModel.class,
                R.layout.player_underteam_layout,
                UnderTeamHolder.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(UnderTeamHolder viewHolder, PlayerModel model, int position) {

               final String keyplayer=getRef(position).getKey();
               final String _id = getIntent().getExtras().getString("teamsid");


                //Log.w("gr",keyplayer);


                viewHolder.setPlayerPhoto(getApplicationContext(), model.getPlayerPhoto());
                viewHolder.setPlayerName(model.getPlayerName());
                viewHolder.setPosition(model.getPosition());

                viewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                      Intent click=new Intent(DisplayTeam.this,DisplayPlayerStat.class);
                      click.putExtra("playersid",keyplayer);
                      click.putExtra("teamsid", _id);
                      startActivity(click);

                    }
                });

            }
        };

        mRecyclerview.setAdapter(firebaseRecyclerAdapter);

    }
}
