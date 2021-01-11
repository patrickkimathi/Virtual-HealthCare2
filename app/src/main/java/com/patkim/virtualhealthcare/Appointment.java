package com.patkim.virtualhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Appointment extends AppCompatActivity {
    private TextView textView4;
    private Spinner doctspinner;
    private TextView docshedule;
    private  TextView book;
    //private EditText patientfeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        textView4= findViewById(R.id.textView4);
        doctspinner =findViewById(R.id.doctspinner);
        docshedule= findViewById(R.id.docschedule);
        book = findViewById(R.id.book);
        //patientfeedback = findViewById(R.id.patientfeedback);


        docshedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appointIntent= new Intent(getApplicationContext(), Schedule.class);
                startActivity(appointIntent);
            }
        });
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookIntent = new Intent(getApplicationContext(), ConsultationActivity.class);
                startActivity(bookIntent);
            }
        });
    }
}