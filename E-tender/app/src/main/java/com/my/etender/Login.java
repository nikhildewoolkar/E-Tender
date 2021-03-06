package com.my.etender;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.SignInMethodQueryResult;

import java.security.Provider;

public class Login extends AppCompatActivity {
    private int c=0;
    private EditText logEmail;
    private EditText logPass;
    private Button login;
    private Button signout;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "AddItemsToDatabase";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        logEmail = (EditText) findViewById(R.id.logeditTextEmail);
        logPass = (EditText) findViewById(R.id.logeditTextPassword);
        login = (Button) findViewById(R.id.login);

        signout=(Button)findViewById(R.id.logout);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    System.out.println("yaya"+user.getUid());
                    toastMessage("Successfully signed in with: " + user.getEmail());
                    c=1;
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    toastMessage("Successfully signed out.");
                }

            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //Users s=new Users(logEmail.getText().toString(),logPass.getText().toString());
                String email = logEmail.getText().toString();

                String pass = logPass.getText().toString();
                hhh();

                if (!email.equals("") && !pass.equals("")) {

                    mAuth.signInWithEmailAndPassword(email, pass);
                    if(c==1) {
                        Intent g = new Intent(Login.this,chooseOption.class);
                        startActivity(g);
                        finish();
                    }
                    //        else if(c==0)
                    //          toastMessage("enter valid details");
                } else {
                    toastMessage("You didn't fill in all the fields.");
                }
                if(c==0)
                    toastMessage("enter valid details");


            }
        });


        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                toastMessage("Signing Out...");
            }
        });




    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void hhh() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    System.out.println("yaya" + user.getUid());
                    toastMessage("Successfully signed in with1111: " + user.getEmail());
                    c=1;
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                    toastMessage("Successfully signed out.");
                    c=0;
                }

            }
        };
    }
}