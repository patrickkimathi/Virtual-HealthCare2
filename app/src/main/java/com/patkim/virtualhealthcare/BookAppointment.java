package com.patkim.virtualhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookAppointment extends AppCompatActivity {
    TextView appoint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);
        TextView appoint= findViewById(R.id.appointtextViewlogo);
        TextView  findClinic= findViewById(R.id.findClinic);
        TextView doctorprev= findViewById(R.id.doctorpreview);

        appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appointIntent= new Intent(getApplicationContext(), Appointment.class);
                startActivity(appointIntent);
            }
        });
    }
}