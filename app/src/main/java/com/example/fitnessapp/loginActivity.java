package com.example.fitnessapp;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
    Button button_login, button_signup;
    Switch remember;
    TextView tv_username, tv_password;
    String username, password;

    String description;
    DbHelper DB;
    SharedPreferences sp;
    SharedPreferences.Editor spe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button_login = findViewById(R.id.button_Login);
        button_signup = findViewById(R.id.button_signUp);
        remember = findViewById(R.id.switch_remember);
        tv_username = findViewById(R.id.text_userName);
        tv_password = findViewById(R.id.text_password);
        DB = new DbHelper(this);
        //removeData();
        loadData();

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

                if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(),"Please Enter All Fields",Toast.LENGTH_SHORT).show();  ;
                }
                else {
                    Boolean checkUserPass = DB.checkUsernamePassword(username,password);
                    if(checkUserPass) {
                        Toast.makeText(getApplicationContext(),"Logged In",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                        intent.putExtra("userID", username);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    public void saveData() {
        sp = getPreferences(MODE_PRIVATE);
        spe = sp.edit();
        spe.putString("key_username", tv_username.getText().toString());
        spe.putString("key_password", tv_password.getText().toString());
        spe.putBoolean("key_remember", remember.isChecked());
        spe.commit();
    }
    public void loadData() {
        sp = getPreferences(MODE_PRIVATE);

        remember.setChecked(sp.getBoolean("key_remember", false));
        if (remember.isChecked() == false) {
            removeData();
        }
        else {
            tv_username.setText(sp.getString("key_username", null));
            tv_password.setText(sp.getString("key_password", null));
        }
    }
    public void removeData() {
        sp = getPreferences(MODE_PRIVATE);
        spe = sp.edit();
        spe.remove("key_username");
        spe.remove("key_password");
        spe.commit();
    }
}