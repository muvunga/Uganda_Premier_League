package com.example.hangi.fufa.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hangi.fufa.DisplayNewsContent;
import com.example.hangi.fufa.Models.Model;
import com.example.hangi.fufa.R;
import com.example.hangi.fufa.ViewHolders.ViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.R.attr.key;
import static android.content.ContentValues.TAG;

/**
 * Created by hangi on 3/28/18.
 */

public class NEWSFRAG extends Fragment {
    View view;
    private DatabaseReference databaseReference;
    private RecyclerView mRecyclerview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.upl_news_fragment,container,false);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("news");

        mRecyclerview = view.findViewById(R.id.news_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        mRecyclerview.setLayoutManager(layoutManager);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(
                Model.class,
                R.layout.items_news,
                ViewHolder.class,
                databaseReference
        ) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                final String KeyRef=getRef(position).getKey();

                viewHolder.setNewstitle(model.getNewstitle());
                //viewHolder.setNewscontent(model.getNewscontent());
                viewHolder.setImg(getContext(), model.getImg());

                //onclick event for the  recyclerview and load content in the new activity

                viewHolder.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "onClick: clicked on");
                       // Toast.makeText(getContext(),KeyRef,Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(getContext(),DisplayNewsContent.class);
                        intent.putExtra("newsid", KeyRef);
                        startActivity(intent);
                       

                    }
                });



            }

        };
        mRecyclerview.setAdapter(firebaseRecyclerAdapter);


    }

}
