package com.example.budget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class MainActivity extends AppCompatActivity {

    public backend bck= new backend();
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



        bck.getBudget(new FirebaseCallback() {
            @Override
            public void onCallback(double value) {
                budget_text.setText("Budget: "+value);
            }
        });

        bck.getDays(new FirebaseCallback() {
            @Override
            public void onCallback(double value) {
                days_text.setText("Days: "+value);
            }
        });

        //SET BUDGET button
        set_bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String bug_text = budget_input.getText().toString();
                if (bug_text.length() == 0){
                    budget_input.setError("Enter a value");
                }else {
                    bck.setBudget(Double.parseDouble(bug_text));
                    bck.getBudget(new FirebaseCallback() {
                        @Override
                        public void onCallback(double value) {
                            budget_text.setText("Budget: "+value);
                        }
                    });

                }
            }
        });

        //SET Days button
        set_days.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String d_text = days_input.getText().toString();
                if (d_text.length() == 0){
                    days_input.setError("Enter a value");
                }else {
                    bck.setDays(Double.parseDouble(d_text));
                    bck.getDays(new FirebaseCallback() {
                        @Override
                        public void onCallback(double value) {
                            days_text.setText("Days: "+value);
                        }
                    });

                }
            }
        });

        //minus listener
        day_min.setOnClickListener(new View.OnClickListener() {
            double r_days;
            @Override
            public void onClick(View view) {
                bck.getDays(new FirebaseCallback() {
                    @Override
                    public void onCallback(double value) {
                        r_days = bck.days_minus(value);

                    }
                });
                days_text.setText("Days: "+r_days);
                bck.setDays(r_days);
            }
        });

        //spent_today
        sp_td.setOnClickListener(new View.OnClickListener() {
            double bug,paise;
            @Override
            public void onClick(View view) {
                String d_text = sp_td_input.getText().toString();
                if (d_text.length() == 0){
                    days_input.setError("Enter a value");
                }else {
                    paise = Double.parseDouble(d_text);
                    bck.getBudget(new FirebaseCallback() {
                        @Override
                        public void onCallback(double value) {
                            bug = value;
                        }
                    });
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    double new_bug = bck.spent_today(bug, paise);
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    bck.setBudget(new_bug);
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    Log.w("Ok multiples","nothing");
                    bck.getBudget(new FirebaseCallback() {
                        @Override
                        public void onCallback(double value) {
                            budget_text.setText("Budget: " + value);
                        }
                    });
                }
            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            double d_z, b_g;
            @Override
            public void onClick(View view) {
                bck.getBudget(new FirebaseCallback() {
                    @Override
                    public void onCallback(double value) {
                        b_g = value;
                    }
                });
                bck.getDays(new FirebaseCallback() {
                    @Override
                    public void onCallback(double value) {
                        d_z = value;
                    }
                });
                double per_day = bck.calculate_budget(d_z,b_g);
                perday_text.setText("Per Day: "+per_day);
            }
        });




    }
}