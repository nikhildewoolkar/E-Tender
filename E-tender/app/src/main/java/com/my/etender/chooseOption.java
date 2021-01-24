package com.my.etender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chooseOption extends AppCompatActivity {
    private Button opt1;
    private Button opt2;
    private Button opt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_option);
        opt1=(Button)findViewById(R.id.opt1);
        opt2=(Button)findViewById(R.id.opt2);
        opt3=(Button)findViewById(R.id.opt3);

        opt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(chooseOption.this,showCategories.class);
                startActivity(i);
            }
        });

        opt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(chooseOption.this,categories.class);
                startActivity(i);
            }
        });

        opt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(chooseOption.this,Result.class);
                startActivity(i);
            }
        });

    }
}
