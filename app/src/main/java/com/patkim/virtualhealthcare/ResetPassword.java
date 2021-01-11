package com.patkim.virtualhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetPassword extends AppCompatActivity {
    TextView pswdreset;
    EditText password, reenterpswd;
    Button confirmbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);



        pswdreset= findViewById(R.id.pswdreset);
        password= findViewById(R.id.password);
        confirmbutton= findViewById(R.id.confirmbutton);
        reenterpswd= findViewById(R.id.reenterPswd);

        Intent intent= getIntent();
        Username.setText(intent.getStringExtra("username"));
        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String Password= password.getText().toString();
                String RetypePassword= reenterpswd.getText().toString();
                if (Password.equals(RetypePassword)) {


                    Boolean checkpasswordupdate = SqliteHelper.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), Login.class);
                        startActivity(intent);
                        Toast.makeText(ResetPassword.this, "Password Reset Successfully", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ResetPassword.this, "Password Not Reset! , Please Try again", Toast.LENGTH_LONG).show();
                    }
                }else

                {
                        Toast.makeText(ResetPassword.this, "Password did not Match",Toast.LENGTH_LONG).show();
                }
             }
        });

    }
}