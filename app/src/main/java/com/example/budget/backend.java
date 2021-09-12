package com.example.budget;


import static android.content.ContentValues.TAG;

import android.app.Application;
import android.os.Handler;
import android.util.Log;
import android.util.TimeUtils;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.functions.FirebaseFunctions;

import java.util.concurrent.TimeUnit;

public class backend extends Application {

    private FirebaseFunctions mFunctions;

    //private FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
    @Override
    public void onCreate(){
        //FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/").setPersistenceEnabled(true);
        //database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
        //database.setPersistenceEnabled(true);

        super.onCreate();
    }


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

//    private double reading_budget(){
//        Log.w(TAG, "START OF FUNC");
//        final String[] budget_val = new String[1];
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
//        String vals = database.getReference("budget").toString();
//        Log.w("daabse",vals);
//        DatabaseReference myRef = database.getReference().child("budget");
//
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                if (dataSnapshot.exists()){
//                    Log.w(TAG,"OK man yes");
//                }else {                   Log.w(TAG,"OK man no");
//                }
//                String value = dataSnapshot.getValue().toString();
//                budget_val[0] = value;
//                Log.w(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//
//        double r_B_val = -1;
//
//        r_B_val = Double.parseDouble(budget_val[0]);
//        return r_B_val;
//    }

//    public double reading_days(){
//        final String[] budget_val = new String[1];
//        final double[] r_B_val = new double[1];
//        FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
//        DatabaseReference myRef = database.getReference().child("days");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue().toString();
//                budget_val[0] = value;
//                r_B_val[0] = Double.parseDouble(budget_val[0]);
//                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
//        return r_B_val[0];
//    }


      public void setBudget(double budget){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference().child("budget");
        //String bud_val = String.valueOf(budget);
        myRef.setValue(budget);
    }
    public void setDays(double days){
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
        DatabaseReference myRef = database.getReference().child("days");
//        String bud_val = String.valueOf(days);
        myRef.setValue(days);
    }

    public void getBudget(FirebaseCallback firebaseCallback){
        Log.w(TAG, "START OF FUNC");
        final String[] budget_val = new String[1];
        final double[] r_B_val = new double[1];
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
        String vals = database.getReference("budget").toString();
        Log.w("daabse",vals);
        DatabaseReference myRef = database.getReference().child("budget");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()){
                    Log.w(TAG,"OK man yes");
                }else {                   Log.w(TAG,"OK man no");
                }
                String value = dataSnapshot.getValue().toString();
                budget_val[0] = value;
                r_B_val[0] = Double.parseDouble(budget_val[0]);
                firebaseCallback.onCallback(r_B_val[0]);

                Log.w(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    public void getDays(FirebaseCallback firebaseCallback){
        Log.w(TAG, "START OF FUNC");
        final String[] budget_val = new String[1];
        final double[] r_B_val = new double[1];
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://budget-app-fb18f-default-rtdb.europe-west1.firebasedatabase.app/");
        String vals = database.getReference("budget").toString();
        Log.w("daabse",vals);
        DatabaseReference myRef = database.getReference().child("days");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                if (dataSnapshot.exists()){
                    Log.w(TAG,"OK man yes");
                }else {                   Log.w(TAG,"OK man no");
                }
                String value = dataSnapshot.getValue().toString();
                budget_val[0] = value;
                r_B_val[0] = Double.parseDouble(budget_val[0]);
                firebaseCallback.onCallback(r_B_val[0]);

                Log.w(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }


}

interface FirebaseCallback{

    void onCallback(double value);
}