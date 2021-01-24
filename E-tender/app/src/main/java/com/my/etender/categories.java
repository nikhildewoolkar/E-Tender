package com.my.etender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class categories extends AppCompatActivity {
    private Button next;
    RadioGroup radioGroup;
    RadioButton genderradioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        next = (Button) findViewById(R.id.next);
        radioGroup=(RadioGroup)findViewById(R.id.RadioGroup);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="";
                int selectedId = radioGroup.getCheckedRadioButtonId();
                genderradioButton = (RadioButton) findViewById(selectedId);
                if(selectedId==-1){
                    Toast.makeText(categories.this,"Nothing selected", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(categories.this,genderradioButton.getText(), Toast.LENGTH_SHORT).show();
                    s=genderradioButton.getText().toString();
                }










//
//                // Is the button now checked?
//                boolean checked = ((RadioButton) v).isChecked();
//                String s="";
//                // Check which radio button was clicked
//                switch(v.getId()) {
//                    case R.id.opt1:
//                        if (checked)
//                            s="Flyover";
//                            break;
//                    case R.id.opt2:
//                        if (checked)
//                            s="Bridge";
//                            break;
//                    case R.id.opt3:
//                        if (checked)
//                            s="Building";
//                            break;
//                    case R.id.opt4:
//                        if (checked)
//                            s="Road";
//                            break;
//                    case R.id.opt5:
//                        if (checked)
//                            s="Colony";
//                            break;
//                }
                Intent i= new Intent(categories.this,TenderForm.class);
                i.putExtra("Category",s);
                startActivity(i);
            }
        });
    }
}
