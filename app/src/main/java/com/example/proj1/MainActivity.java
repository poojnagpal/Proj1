package com.example.proj1;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
//import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.DatePicker;
import android.app.Dialog;
import android.app.DatePickerDialog;
import android.widget.Toast;

//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;
import java.util.Calendar;
import java.util.*;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

        private EditText input1;

        private TextView viewed_result_distance;

        private ProgressBar battery_status;

        private TextView viewed_result_battery;

        private DatePicker date_picker;

        private TextView viewed_result_spinner;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            input1 = (EditText) findViewById(R.id.et_input1);

            Button bt_calculate = (Button) findViewById(R.id.bt_calculate);

            viewed_result_distance = (TextView) findViewById(R.id.viewed_result);

            battery_status = (ProgressBar) findViewById(R.id.progressBar9);

            viewed_result_battery = (TextView) findViewById(R.id.textView);

            viewed_result_spinner = (TextView) findViewById(R.id.spinnerText);

            date_picker = (DatePicker) findViewById(R.id.datePicker1);

            int year = date_picker.getYear();
            int month = date_picker.getMonth();

            String[] cars = { "Honda Accord", "Toyota Prius", "Tesla", "Tesla Model X", "Other" };
            Spinner spin = (Spinner) findViewById(R.id.spinner1);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cars);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spin.setAdapter(adapter);
            Toast.makeText(MainActivity.this, spin.getSelectedItem().toString() + "max mph: 129", Toast.LENGTH_LONG).show();
            viewed_result_spinner.setText(spin.getSelectedItem().toString() + " has mediocre mileage");





            Button bt_select_date = (Button) findViewById(R.id.bt_select_date);


            bt_select_date.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("hi");
                    Toast.makeText(MainActivity.this, date_picker.getDayOfMonth() + "/" + date_picker.getMonth() + "/" + date_picker.getYear(), Toast.LENGTH_LONG).show();
                }
            });


            bt_calculate.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculateDistance();
                }
            });
        }

        private void calculateDistance() {
            double distance_input = Double.valueOf(input1.getText().toString());

//            double battery_duration = 0;

            double progress_bar_current = Double.valueOf(battery_status.getProgress())/Double.valueOf(battery_status.getMax());

            String progress_bar_percentage = progress_bar_current - 10 * 100 + "%";

            //calculate battery life given the distance and current battery life
            double battery_duration = distance_input * progress_bar_current;

            viewed_result_battery.setText("Current battery level: " + progress_bar_percentage);
            viewed_result_distance.setText("It will take " + battery_duration + " hours to travel "+ distance_input + " miles ");
        }

        // The rest of your Activity and methods.

//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//       FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
