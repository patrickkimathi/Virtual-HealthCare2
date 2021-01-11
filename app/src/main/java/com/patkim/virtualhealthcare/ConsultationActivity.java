package com.patkim.virtualhealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConsultationActivity extends AppCompatActivity {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultation);

        TextView textViewConsult= findViewById(R.id.textViewConsult);
        EditText editTextDoctor= findViewById(R.id.editTextDoctor);
        EditText editTextpatient= findViewById(R.id.editTextpatient);
        TextView docTextView= findViewById(R.id.docTextView);
        TextView pattextView= findViewById(R.id.pattextView);
        TextView endconsultation= findViewById(R.id.endconsultation);
        Button logoutbutton= findViewById(R.id.logoutbutton);

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        endconsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}