package com.example.budget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    public backend value= new backend();
    public Button set_bug ;
    public Button set_days;
    public Button sp_td;
    public Button day_min;
    public Button calc;

    public TextView budget_text;
    public TextView days_text;
    public TextView perday_text;

    public EditText budget_input;
    public EditText days_input;
    public EditText sp_td_input;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //elements
        //buttons
        set_bug = findViewById(R.id.budget_set_button);
        set_days = findViewById(R.id.days_set_button);
        sp_td = findViewById(R.id.spend_set_button);
        day_min = findViewById(R.id.days_minus);
        calc = findViewById(R.id.calculate);

        //TextView
        budget_text = findViewById(R.id.budget_text);
        days_text = findViewById(R.id.days_text);
        perday_text = findViewById(R.id.text_result);

        //edittext
        budget_input = findViewById(R.id.budget_input);
        days_input = findViewById(R.id.days_input);
        sp_td_input = findViewById(R.id.spent_input);



        value.getBudget(new FirebaseCallback() {
            @Override
            public void onCallback(double value) {
                budget_text.setText("Budget: "+value);
            }
        });




    }
}