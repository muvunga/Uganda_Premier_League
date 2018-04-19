package com.example.hangi.fufa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static android.os.Build.VERSION_CODES.N;
import static com.example.hangi.fufa.R.id.TeamName;

/**
 * Created by hangi on 4/6/18.
 */
public class DisplayPlayerStat extends AppCompatActivity {

    private DatabaseReference databaseReference;

   private TextView Pname,Team,Games,Assist,Goal,POST,biod;
    private ImageView profile;


    private static final String TAG="DisplayPlayerStat";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.player_stat_layout);
        super.onCreate(savedInstanceState);
        String id_ = getIntent().getExtras().getString("playersid");
        String Tid_ = getIntent().getExtras().getString("teamsid");
        //String keyplayer=getIntent().getExtras().getString("playersid");


        Log.d(TAG, "onCreate: onCreate: Started");
        databaseReference= FirebaseDatabase.getInstance().getReference().child("players").child(Tid_).child(id_);


        profile=(ImageView)findViewById(R.id.PlayerProfil);

        Pname=(TextView)findViewById(R.id.nAMEpLAYER);
        Team=(TextView)findViewById(R.id.TeamText);
        Games=(TextView)findViewById(R.id.MatchJ);
        Assist=(TextView)findViewById(R.id.AssistB);
        Goal=(TextView)findViewById(R.id.ButsMarque);
        POST=(TextView)findViewById(R.id.position);
        biod=(TextView)findViewById(R.id.contentBio);




        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String Photo= String.valueOf(dataSnapshot.child("playerPhoto").getValue());
                String  Teamname1=String.valueOf(dataSnapshot.child("PlayerTeam").getValue());
                String Player=String.valueOf(dataSnapshot.child("playerName").getValue());
                String Assists=String.valueOf(dataSnapshot.child("Assist").getValue());
                String Goals=String.valueOf(dataSnapshot.child("Goals").getValue());
                String  Game=String.valueOf(dataSnapshot.child("Games").getValue());
                String Pst=String.valueOf(dataSnapshot.child("position").getValue());
                String biodat=String.valueOf(dataSnapshot.child("biography").getValue());



                Picasso.with(DisplayPlayerStat.this).load(Photo).into(profile);
                Team.setText(Teamname1);
                Pname.setText(Player);
                Games.setText(Game);
                Assist.setText(Assists);
                Goal.setText(Goals);
                POST.setText(Pst);
                biod.setText(biodat);



            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
