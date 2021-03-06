package com.patkim.virtualhealthcare;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class UpdateSchedule<arrayAdapter> extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //DatePicker datePicker;
    Button submitbtn;
    Spinner spinnerstatus;
    //DatePicker datePickerDialog;
    EditText date_time;
    String[] Specialist = {"Nurse", "Dentist", "Clinician"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_schedule);

        //Iniate the variables
        spinnerstatus = findViewById(R.id.spinnerstatus);
        submitbtn = findViewById(R.id.submitbtn);

        //Creating ArrayAdapeter and applying setOnItemSelectedListener
        spinnerstatus.setOnItemSelectedListener(this);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Specialist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerstatus.setAdapter(arrayAdapter);

        //setting the arrayadapter on the Spinner
        spinnerstatus.setAdapter(arrayAdapter);

        date_time = findViewById(R.id.date);
        date_time.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                showDateTimeDialog(date_time);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDateTimeDialog(final EditText date_time) {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy/mm/dd hh:min");
                        date_time.setText(simpleDateFormat.format(calendar));
                    }
                };
                new TimePickerDialog(UpdateSchedule.this, timeSetListener,
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE), false);
            }
        };
        new DatePickerDialog(UpdateSchedule.this, dateSetListener,
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.HOUR_OF_DAY));
    }


        //Creating ArrayAdapeter and applying setOnItemSelectedListener
        //List<String> Specialist = null;

   /* ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Specialist);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //setting the arrayadapter on the Spinner
        spinnerstatus.setAdapter(arrayAdapter);

    */



    public void onItemSelected(AdapterView<?> parent,
                               View view, int position, long id) {
        Toast.makeText(getApplicationContext(), Specialist[position],
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


   }

   /*final Calendar myCalender = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //autogenerated method method stub
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, month);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                //myCalender.set(Calendar.HOUR_OF_DAY,hourOfDay);
                updateLabel1();

            }

            private void updateLabel1() {
                String format = "MM/dd/yy";
                SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
                date_time.setText(dateFormat.format(myCalender.getTime()));

            }
        };

         */