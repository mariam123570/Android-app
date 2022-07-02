package com.example.login3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login3.Homepage2;
import com.example.login3.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {


    ImageView google_img;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.username);
        TextView password = (TextView) findViewById(R.id.password);
        TextView forgetpassword = (TextView) findViewById(R.id.forgotpassword);
        ImageView twitter = (ImageView) findViewById(R.id.twitter);
        ImageView google = (ImageView) findViewById(R.id.google);
        Button loginbtn = (Button) findViewById(R.id.loginbtn);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

       // gsc=new GoogleSignIn.getClient(this,gso);

        google_img.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                SignIn();
            }
        });

        loginbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // launch to the home page...

                Intent i = new Intent(MainActivity.this, Homepage2.class);
                startActivity(i);

            }

            });




    }

    private void SignIn() {
        Intent intent=gsc.getSignInIntent();
        startActivityForResult(intent,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            Task<GoogleSignInAccount> task=GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                homepage2();
            } catch (ApiException e){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();

            }

        }
    }

    private void homepage2() {
        finish();
        Intent intent = new Intent (getApplicationContext(),Homepage2.class);
        startActivity(intent);
    }
}