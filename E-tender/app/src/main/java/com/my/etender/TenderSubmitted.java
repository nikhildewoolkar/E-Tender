package com.my.etender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TenderSubmitted extends AppCompatActivity {
    private Button seeRes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_submitted);
        seeRes=(Button)findViewById(R.id.showresbutton);
        seeRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TenderSubmitted.this,Result.class);
                startActivity(i);
            }
        });
    }

}
