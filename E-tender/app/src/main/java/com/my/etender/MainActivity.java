package com.my.etender;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


        private static int SPLASH_TIME_OUT=1500;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_main);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    System.out.println("************maafterrhhhhhhfffffffffffffffffffffffffffffffffff******************************************************************");
                    Intent i=new Intent(MainActivity.this,chooseActivity.class);
                    startActivity(i);
                    finish();
                }
            },SPLASH_TIME_OUT);


            getSupportActionBar().hide();
        }

}

