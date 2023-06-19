package com.example.comi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends MainActivity{
    EditText username, password, repassword;
    Button signUp;
    TextView loginClient;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        username = (EditText) findViewById(R.id.signup_username);
        password = (EditText) findViewById(R.id.signup_pass);
        repassword = (EditText) findViewById(R.id.signup_repass);
        signUp = (Button) findViewById(R.id.signup_btn);
        loginClient=(TextView)findViewById(R.id.login_client);
        databaseHelper = new DatabaseHelper(this);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Signup.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)){
                        Boolean checkuser = databaseHelper.checkUserName(user);
                        if (checkuser == false){
                            Boolean insert = databaseHelper.insertData(user, pass);
                            if (insert == true){
                                Toast.makeText(Signup.this, "Signup successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Signup.this, "Sign failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(Signup.this, "User already exists, Please login", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Signup.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        loginClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
