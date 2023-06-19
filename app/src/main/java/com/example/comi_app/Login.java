package com.example.comi_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    TextView signupClient;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        username = (EditText) findViewById(R.id.edtEmail);
        password = (EditText) findViewById(R.id.edtPass);
        btnLogin = (Button) findViewById(R.id.btnlg);
        databaseHelper = new DatabaseHelper(this);

        signupClient=(TextView)findViewById(R.id.signup_client);
        signupClient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login.this, Signup.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))
                    Toast.makeText(Login.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = databaseHelper.checkUserPassword(user,pass);
                    if (checkuserpass == true){
                        Toast.makeText(Login.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
