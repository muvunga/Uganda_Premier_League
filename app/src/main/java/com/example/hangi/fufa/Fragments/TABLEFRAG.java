package com.example.hangi.fufa.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hangi.fufa.Models.TableModel;
import com.example.hangi.fufa.R;
import com.example.hangi.fufa.ViewHolders.TableHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by hangi on 3/28/18.
 */

public class TABLEFRAG extends Fragment {

        View view;
    private RecyclerView tableRecycler;
    DatabaseReference databaseReference;
    public TABLEFRAG() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        view=inflater.inflate(R.layout.upl_table_fragment,container,false);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("table");
        tableRecycler=(RecyclerView) view.findViewById(R.id.table_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(false);
        layoutManager.setStackFromEnd(false);

        tableRecycler.setLayoutManager(layoutManager);

        return view;
    }


    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<TableModel,TableHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<TableModel, TableHolder>(
                TableModel.class,
                R.layout.table_items,
                TableHolder.class,
                databaseReference

        ) {
            @Override
            protected void populateViewHolder(TableHolder viewHolder, TableModel model, int position) {

               viewHolder.setTeamNames(model.getTeamNames());
                viewHolder.setTeamsPoints(model.getTeamsPoints());

            }
        };
        tableRecycler.setAdapter(firebaseRecyclerAdapter);
    }
}
