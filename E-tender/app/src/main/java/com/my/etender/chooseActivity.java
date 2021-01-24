package com.my.etender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseActivity extends AppCompatActivity {
    private Button reg;
    private Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        reg = (Button) findViewById(R.id.newuser);
        log = (Button) findViewById(R.id.olduser);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r=new Intent(chooseActivity.this,Register.class);
                startActivity(r);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent r=new Intent(chooseActivity.this,Login.class);
                startActivity(r);
            }
        });
    }
}
