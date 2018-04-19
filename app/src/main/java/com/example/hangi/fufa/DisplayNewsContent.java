package com.example.hangi.fufa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DisplayNewsContent extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private ImageView imageView;
    private TextView newsTITLE,newsCONTENT;
    private static final String TAG="DisplayNewsContent";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_news_content);

        Log.d(TAG, "onCreate: onCreate: Started");
     databaseReference= FirebaseDatabase.getInstance().getReference().child("news");
        String KeyRef=getIntent().getExtras().getString("newsid");
        //Toast.makeText(DisplayNewsContent.this,KeyRef,Toast.LENGTH_LONG).show();

        imageView=(ImageView)findViewById(R.id.newsImageView);

        newsTITLE=(TextView)findViewById(R.id.TitleNews);
        newsCONTENT=(TextView)findViewById(R.id.contentnews);


        databaseReference.child(KeyRef).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String NEWSPHOTO=(String)dataSnapshot.child("img").getValue();
                String NEWSTITLE=(String)dataSnapshot.child("newstitle").getValue();
                String NEWSCONTENT=(String)dataSnapshot.child("newscontent").getValue();

                Picasso.with(DisplayNewsContent.this).load(NEWSPHOTO).into(imageView);
                newsTITLE.setText(NEWSTITLE);
                newsCONTENT.setText(NEWSCONTENT);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
