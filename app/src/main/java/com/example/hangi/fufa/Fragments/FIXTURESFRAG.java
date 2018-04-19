package com.example.hangi.fufa.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangi.fufa.Models.Model2;
import com.example.hangi.fufa.R;
import com.example.hangi.fufa.ViewHolders.HolderView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hangi on 3/28/18.
 */

public class FIXTURESFRAG extends Fragment {
        View view;

    private DatabaseReference mdatabase;
    private RecyclerView fixturesRecyclerview;



    public FIXTURESFRAG() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.upl_fixtures_fragment,container,false);

        mdatabase=FirebaseDatabase.getInstance().getReference().child("fixtures");

        fixturesRecyclerview=view.findViewById(R.id.fixtures_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        fixturesRecyclerview.setLayoutManager(layoutManager);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model2,HolderView>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Model2, HolderView>(
                Model2.class,
                R.layout.fixture_items,
                HolderView.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(HolderView viewHolder, Model2 model, int position) {

                viewHolder.setTeamA(getContext(),model.getTeamA());
                viewHolder.setGameTime(model.getGameTime());
                viewHolder.setTeamB(getContext(),model.getTeamB());
            }
        };

        fixturesRecyclerview.setAdapter(firebaseRecyclerAdapter);
    }

    //    @Override
//    public void onStart() {
//        super.onStart();
//
//
//        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(
//                Model.class,
//                R.layout.fixture_items,
//                ViewHolder.class,
//                databaseReference) {
//            @Override
//            protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
//
////                viewHolder.setTeamA(getContext(),model.getTeamA());
////
////                viewHolder.setTeamB(getContext(),model.getTeamB());
////                viewHolder.setGameTime(model.getGameTime());
//            }
//        };

       // kRecyclerview.setAdapter(firebaseRecyclerAdapter);

//        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(
//                Model.class,
//                R.layout.fixture_items,
//                ViewHolder.class,
//                mdatabase
//        ){
//
//            @Override
//            protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
//
////                viewHolder.setTeamA(getContext(),model.getTeamA());
////                viewHolder.setGameTime(model.getGameTime());
////                viewHolder.setTeamB(getContext(),model.getTeamB());
//
//            }
//
////            @Override
////            protected void populateViewHolder(FixtureViewHolder viewHolder, FixtureModel model, int position) {
////                viewHolder.setTeamA(getContext(),model.getTeamA());
////                viewHolder.setGameTime(model.getGameTime());
////                viewHolder.setTeamB(getContext(),model.getTeamB());
////
////            }
//        };
//
//        fRecyclerview.setAdapter(firebaseRecyclerAdapter);
    }

