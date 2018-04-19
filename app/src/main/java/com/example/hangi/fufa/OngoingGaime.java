package com.example.hangi.fufa;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hangi.fufa.Models.ResultModel;
import com.example.hangi.fufa.ViewHolders.ResultHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by hangi on 4/5/18.
 */

public class OngoingGaime extends AppCompatActivity {

    private DatabaseReference databaseReference;
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_recycler);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("results");
        mRecyclerview = (RecyclerView) findViewById(R.id.resultrecycler);

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
                String resultId = dataSnapshot.getValue().toString();
                Log.w("Test", resultId);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        FirebaseRecyclerAdapter<ResultModel,ResultHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<ResultModel, ResultHolder>(
               ResultModel.class,
                R.layout.results_layout,
                ResultHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(ResultHolder viewHolder, ResultModel model, int position) {
                viewHolder.setTEAMB(model.getTEAMB());
                viewHolder.setTEAMA(model.getTEAMA());
                viewHolder.setRESULT(model.getRESULT());
                viewHolder.setTeamPhoto1(getApplicationContext(),model.getTeamPhoto1());
                viewHolder.setTeamphoto2(getApplicationContext(),model.getTeamphoto2());

//               viewHolder.view.setOnClickListener(new View.OnClickListener() {
//                   @Override
//                   public void onClick(View view) {
//
//                   }
//               });
            }
        };
        mRecyclerview.setAdapter(firebaseRecyclerAdapter);
    }
}
