package com.example.hangi.fufa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.hangi.fufa.Models.TeamModel;
import com.example.hangi.fufa.ViewHolders.TeamHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class TeamList extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.upl_teams_fragment);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("teams");
        mRecyclerview = (RecyclerView) findViewById(R.id.teamRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        mRecyclerview.setLayoutManager(layoutManager);


    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String playerId = dataSnapshot.getValue().toString();
                Log.w("Test", playerId);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FirebaseRecyclerAdapter<TeamModel,TeamHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<TeamModel, TeamHolder>(
                TeamModel.class,
                R.layout.team_list,
                TeamHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(TeamHolder viewHolder, TeamModel model, int position) {
                final String KeyRef=getRef(position).getKey();

                viewHolder.setTeamPhoto(TeamList.this, model.getTeamPhoto());
               // viewHolder.setManager(model.getManager());
                viewHolder.setTeamName(model.getTeamName());
//                viewHolder.setGamePlayed(String.valueOf(model.getGamePlayed()));
//                viewHolder.setGamesWon(String.valueOf(model.getGamesWon()));
//                viewHolder.setGamesLost(String.valueOf(model.getGamesLost()));
//                viewHolder.setDraws(String.valueOf(model.getDraws()));



                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getApplicationContext(),DisplayTeam.class);
                        intent.putExtra("teamsid", KeyRef);
                        startActivity(intent);
                    }
                });
            }
        };

        mRecyclerview.setAdapter(firebaseRecyclerAdapter);
    }
}
