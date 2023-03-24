package com.example.fitnessapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    Button button_login, button_signup;
    //Switch switch_remember;
    TextView tv_username, tv_password;
    String username, password;

    String description;
    //boolean remember; // I plan on doing this eventually
    DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login = findViewById(R.id.button_Login);
        button_signup = findViewById(R.id.button_signUp);
        //switch_remember = findViewById(R.id.switch_remember);
        tv_username = findViewById(R.id.text_userName);
        tv_password = findViewById(R.id.text_password);
        DB = new DbHelper(this);

        button_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = tv_username.getText().toString();
                password = tv_password.getText().toString();

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),"Enter All Fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkUser = DB.checkUsername(username);
                    if (checkUser == false) {
                        boolean insert = DB.insertUsernamePassword(username,password);
                        if (insert) {
                            Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Registration Failed",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"User Already Exists",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = tv_username.getText().toString();
                password = tv_password.getText().toString();

                DB.insertWorkouts(username, "Curls", "3-23-2023");  //This adds a sample workout when logging in

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),"Please Enter All Fields",Toast.LENGTH_SHORT).show();  ;
                }
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(username,password);
                    if(checkUserPass) {
                        Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}