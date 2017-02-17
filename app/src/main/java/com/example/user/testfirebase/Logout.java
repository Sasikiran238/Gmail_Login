package com.example.user.testfirebase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Logout extends AppCompatActivity {

    Button logout_gmail;


    FirebaseAuth myauth;
    FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);

        myauth=FirebaseAuth.getInstance();

        logout_gmail=(Button)findViewById(R.id.button_signout);
        logout_gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myauth.signOut();
            }
        });

     authStateListener=new FirebaseAuth.AuthStateListener() {
         @Override
         public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

             if(firebaseAuth.getCurrentUser()==null){


                 Intent in1=new Intent(Logout.this,MainActivity.class);
                 startActivity(in1);
             }
         }
     };

    }
    @Override
    public void onStart() {
        super.onStart();
        myauth.addAuthStateListener(authStateListener);
    }
}
