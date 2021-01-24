package com.my.etender;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result extends AppCompatActivity {
    DatabaseReference databaseReference;
    Users info;
    List<String> itemlist1;

    public int c=0,min=0,min2=0,index=0,index1=0;
    public String user_name1[]=new String[100];
    public String user_budget1[]=new String[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        itemlist1 = new ArrayList<>();

        c = 0;
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                itemlist1.clear();
//                Map<String, Object> map = (HashMap<String, Object>) dataSnapshot.child("Building").getValue();
//                for (String key3 : map.keySet()) {
//                    user_key1[c] = key3;
//                    System.out.println(key3);
//                    c = c + 1;
//                }

                c = 0;
                min=0;
                min2=0;
                index=0;
                index1=0;
                Map<String, Object> map2 = (HashMap<String, Object>) dataSnapshot.child("Building").getValue();
                assert map2 != null;
                for (String key : map2.keySet()) {
                    user_name1[c] = (String) dataSnapshot.child("Building").child(key).child("Name").getValue();
                    user_budget1[c] = (String) dataSnapshot.child("Building").child(key).child("Budget").getValue();
                    itemlist1.add(user_name1[c]);
                    if(min==0)
                    {min=Integer.parseInt(user_budget1[c]);
                    min2=min;
                    index=c;
                    index1=c;}

                    else{
                        if(min>Integer.parseInt(user_budget1[c])){
                            min=Integer.parseInt(user_budget1[c]);
                            index=c;
                        }
                        if(Integer.parseInt(user_budget1[c])<min2 && Integer.parseInt(user_budget1[c])>min){
                            min2=Integer.parseInt(user_budget1[c]);
                            index1=c;
                        }
                    }
//                    System.out.println("***************************itlist***"+itemlist1+"**************************");
                    c = c + 1;


                }
                System.out.println("*************************mina and user"+min+user_name1[index]+"***********");
                System.out.println("*************************mina and user"+min2+user_name1[index1]+"***********");
                TextView res1=(TextView)findViewById(R.id.buildigres1);
                res1.setText("Budget: "+min+" Name: "+user_name1[index]);
                TextView res2=(TextView)findViewById(R.id.buildigres21);
                res2.setText("Budget: "+min2+" Name: "+user_name1[index1]);






                c = 0;
                itemlist1.clear();
                min=0;
                user_name1=new String[100];
                user_budget1=new String[100];
                min2=0;
                index=0;
                index1=0;
                Map<String, Object> map1 = (HashMap<String, Object>) dataSnapshot.child("Bridge").getValue();
                assert map1 != null;
                for (String key : map1.keySet()) {
                    user_name1[c] = (String) dataSnapshot.child("Bridge").child(key).child("Name").getValue();
                    user_budget1[c] = (String) dataSnapshot.child("Bridge").child(key).child("Budget").getValue();
                    itemlist1.add(user_name1[c]);
                    if(min==0)
                    {min=Integer.parseInt(user_budget1[c]);
                        min2=min;
                        index=c;
                        index1=c;}

                    else{
                        if(min>Integer.parseInt(user_budget1[c])){
                            min=Integer.parseInt(user_budget1[c]);
                            index=c;
                        }
                        if(Integer.parseInt(user_budget1[c])<min2 && Integer.parseInt(user_budget1[c])>min){
                            min2=Integer.parseInt(user_budget1[c]);
                            index1=c;
                        }
                    }
                    System.out.println("***************************itlist***8"+itemlist1+"**************************");
                    c = c + 1;


                }
                System.out.println("*************************mina and user"+min+user_name1[index]+"***********");
                System.out.println("*************************mina and user"+min2+user_name1[index1]+"***********");

                TextView res11=(TextView)findViewById(R.id.bridgeres1);
                res11.setText("Budget: "+min+" Name: "+user_name1[index]);
               TextView res21=(TextView)findViewById(R.id.bridgeres21);
                res21.setText("Budget: "+min2+" Name: "+user_name1[index1]);


//
//                c = 0;
//                min=0;
//                min2=0;
//                index=0;
//                user_name1=new String[0];
//                user_budget1=new String[0];
//                itemlist1.clear();
//                index1=0;
//              map2 = (HashMap<String, Object>) dataSnapshot.child("Road").getValue();
//                assert map2 != null;
//                for (String key : map2.keySet()) {
//                    user_name1[c] = (String) dataSnapshot.child("Road").child(key).child("Name").getValue();
//                    user_budget1[c] = (String) dataSnapshot.child("Road").child(key).child("Budget").getValue();
//                    itemlist1.add(user_name1[c]);
//                    if(min==0)
//                    {min=Integer.parseInt(user_budget1[c]);
//                        min2=min;
//                        index=c;
//                        index1=c;}
//
//                    else{
//                        if(min>Integer.parseInt(user_budget1[c])){
//                            min=Integer.parseInt(user_budget1[c]);
//                            index=c;
//                        }
//                        if(Integer.parseInt(user_budget1[c])<min2 && Integer.parseInt(user_budget1[c])>min){
//                            min2=Integer.parseInt(user_budget1[c]);
//                            index1=c;
//                        }
//                    }
//                    System.out.println("***************************itlist***8"+itemlist1+"**************************");
//                    c = c + 1;
//
//
//                }
//                System.out.println("*************************mina and user"+min+user_name1[index]+"***********");
//                System.out.println("*************************mina and user"+min2+user_name1[index1]+"***********");
//
//                res1=(TextView)findViewById(R.id.roadres1);
//                res1.setText("Budget: "+min+"\nName: "+user_name1[index]);
//                res2=(TextView)findViewById(R.id.roadres21);
//                res2.setText("Budget: "+min+"\nName: "+user_name1[index]);





            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "There is some error", Toast.LENGTH_LONG).show();
            }
        });

    }
}
