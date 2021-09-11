package com.example.budget;


import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class backend {

    public double calculate_budget(double days,double budget){
        double per_day = budget / days;
        return per_day;
    }

    public double days_minus(double days){
        return (days-1);
    }

    public double spent_today(double budget,double sp_today){
        return (budget-sp_today);
    }

    public double reading_budget(){
        final String[] budget_val = new String[1];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("budget");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                budget_val[0] = value;
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        double r_B_val = Double.valueOf(budget_val[0]);
        return r_B_val;
    }

    public double reading_days(){
        final String[] budget_val = new String[1];
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("days");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                budget_val[0] = value;
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        double r_B_val = Double.valueOf(budget_val[0]);
        return r_B_val;
    }

    public void writing_budget(double budget){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("budget");
        String bud_val = String.valueOf(budget);
        myRef.setValue(bud_val);
    }
    public void writing_days(double days){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("days");
        String bud_val = String.valueOf(days);
        myRef.setValue(bud_val);
    }



}
