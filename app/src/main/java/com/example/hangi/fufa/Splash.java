package com.example.hangi.fufa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by hangi on 4/5/18.
 */

public class Splash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private ImageView imageView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.splash_screen);


        //Welcome home splash

    imageView=(ImageView)findViewById(R.id.splashscreen);
    final Intent main=new Intent(this,MainActivity.class);

        Thread timer=new Thread(){

            public void run(){

                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {

                    startActivity(main);
                    finish();

                }
            }
        };
                timer.start();
    }
}
