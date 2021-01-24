package com.my.etender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TenderForm extends AppCompatActivity {
    private Button save;
    private Button submit;
    private EditText Name;
    private EditText Phone;
    private EditText Email;
    private EditText Itemlist;
    private EditText Budget;
    private DatabaseReference mDatabase;
    //Firebase Auth
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tender_form);
        save = (Button) findViewById(R.id.save);
        submit = (Button) findViewById(R.id.submit);
        Name = (EditText) findViewById(R.id.regaccName);
        Phone = (EditText) findViewById(R.id.regeditTextPhone);
        Email = (EditText) findViewById(R.id.regeditTextEmail);
        Itemlist = (EditText) findViewById(R.id.regeditTextItemlist);
        Budget = (EditText) findViewById(R.id.regeditTextBudget);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String key = intent.getStringExtra("Category");
                if (!(Name.getText().toString()=="")&& !(Phone.getText().toString()=="")&& !(Itemlist.getText().toString()=="")&& !(Email.getText().toString()=="")&& !(Budget.getText().toString()==""))  {
                    // Sign in success, update UI with the signed-in user's information



                    mDatabase= FirebaseDatabase.getInstance().getReference().child(key).push();

                    HashMap<String ,Object> userMap=new HashMap<>();
                    userMap.put("Name",Name.getText().toString());
                    userMap.put("Email",Email.getText().toString());
                    userMap.put("Phone",Phone.getText().toString());
                    userMap.put("Itemlist",Itemlist.getText().toString());
                    userMap.put("Budget",Budget.getText().toString());
                    mDatabase.setValue(userMap);

                    Intent k = new Intent(TenderForm.this, TenderSubmitted.class);
                    startActivity(k);
                    finish();
            }}
        });
    }
}
