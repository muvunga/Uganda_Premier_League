package com.example.hangi.fufa.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hangi.fufa.OngoingGaime;
import com.example.hangi.fufa.R;
import com.example.hangi.fufa.TeamList;

/**
 * Created by hangi on 3/28/18.
 */

public class STATFRAG extends Fragment {
        View view;

    private Button btnPLayers,btnTeams,btnResult;
    public STATFRAG() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.upl_statistic_fragment,container,false);

        

        btnTeams=(Button)view.findViewById(R.id.btnTeam);
        btnTeams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent teams=new Intent(getActivity(),TeamList.class);
                startActivity(teams);
            }
        });


        btnResult=(Button)view.findViewById(R.id.BtnResults);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent result=new Intent(getActivity(),OngoingGaime.class);
                startActivity(result);
            }
        });

        return view;

    }

    /**
     * Created by hangi on 3/28/18.
     */

    public static class News {
    }
}
