package com.saswat_u7156387.sp_lab_bookmark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Launcher_Login extends AppCompatActivity {

    EditText user_name;
    EditText pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher__login);
        user_name = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);

    }

    public void read_csv_login(View view) {
        String username = user_name.getText().toString();
        String password = pass.getText().toString();
        User user = new User();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("loginDetails.csv"), "UTF-8"));
            String line;
            int flag=0;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(",");
                if(tokens.length==3){//checking if the number of tokens in each line is correct
                    if(tokens[1].equals(username)){
                        if(tokens[2].equals(password)){
                            flag=2;
                            user.setId(tokens[0]);
                            user.setUsername(tokens[1]);
                            user.setPassword(tokens[2]);
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            intent.putExtra("USER",user);
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Password is Incorrect", Toast.LENGTH_SHORT).show();
                            flag=1;
                        }
                    }
                }
            }
            if(flag==0){
                Toast.makeText(getApplicationContext(),"Username is Incorrect", Toast.LENGTH_SHORT).show();
            }
        }
        catch(IOException e){
                e.printStackTrace();
            }
        finally{

            }


        }
    }