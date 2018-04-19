package com.example.hangi.fufa;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.example.hangi.fufa.Fragments.FIXTURESFRAG;
import com.example.hangi.fufa.Fragments.NEWSFRAG;
import com.example.hangi.fufa.Fragments.STATFRAG;
import com.example.hangi.fufa.Fragments.TABLEFRAG;
import com.example.hangi.fufa.ViewHolders.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {


    //adding a splash screen

    private static  int SPLASH_TIMEOUT=5000;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Button ongoinbtn;

    private final int SPLASH_DISPLAY_LENGTH = 1000;
//    RecyclerView recyclerView;
//    Model newsAdapter;
//    List<Model>newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ongoinbtn=(Button)findViewById(R.id.Button);




        //adding a handler


        tabLayout=(TabLayout)findViewById(R.id.tablayout_id);
        adapter=new ViewPagerAdapter(getSupportFragmentManager());

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);



        //Add fragment here

        adapter.AddFragment(new NEWSFRAG(),"NEWS");
        adapter.AddFragment(new FIXTURESFRAG(),"FIXTURES");
        adapter.AddFragment(new TABLEFRAG(),"TABLE");
        adapter.AddFragment(new STATFRAG(),"STATISTICS");
        viewPager.setAdapter(adapter);


        tabLayout.setupWithViewPager(viewPager);


        //tabLayout.getTabAt(3).setIcon(R.drawable.stat);


        //remove shadow from the actionBar


        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);






    }


}
