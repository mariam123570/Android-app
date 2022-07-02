package com.example.login3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

import java.util.jar.Attributes;

public class Homepage2 extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage2);

        TextView myprofile = (TextView) findViewById(R.id.myprofile);
        TextView messages = (TextView) findViewById(R.id.messages);
        TextView requests = (TextView) findViewById(R.id.requests);
        TextView location = (TextView) findViewById(R.id.location);
        TextView settings = (TextView) findViewById(R.id.settings);
        TextView logout = (TextView) findViewById(R.id.logout);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

      //  gsc=new GoogleSignIn.getClient(this , gso);

        GoogleSignInAccount account=GoogleSignIn.getLastSignedInAccount(this);


        }
    }
