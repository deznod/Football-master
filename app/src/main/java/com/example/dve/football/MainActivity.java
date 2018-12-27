package com.example.dve.football;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "StartActivity";
    public Integer counterTeam1 = 0;
    public Integer counterTeam2 = 0;
    TextView counterView = findViewById(R.id.txt_counter);
    TextView counterView2 = findViewById(R.id.txt_counter2);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("SetTextI18n")
    public void onClickBtnAddTeam1(View view) {
        if (counterTeam1 < 20) {
            counterTeam1++;
        } else {
            Toast.makeText(this, R.string.max_count, Toast.LENGTH_LONG).show();
        }
        counterView.setText(counterTeam1.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickBtnAddTeam2(View view) {
        if (counterTeam2 < 20) {
            counterTeam2++;
        } else {
            Toast.makeText(this, R.string.max_count, Toast.LENGTH_LONG).show();
        }

        counterView2.setText(counterTeam2.toString());
    }

    @SuppressLint("SetTextI18n")
    public void onClickBtnReset(View view) {
        counterTeam1 = 0;
        counterTeam2 = 0;

        counterView.setText(counterTeam1.toString());
        counterView2.setText(counterTeam2.toString());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        resetUI();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("counter", counterTeam1);
        outState.putInt("counter2", counterTeam2);
        Log.d(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("counter")) {
            counterTeam1 = savedInstanceState.getInt("counter");
            counterTeam2 = savedInstanceState.getInt("counter2");
        }
        Log.d(TAG, "onRestoreInstanceState");
    }

    @SuppressLint("SetTextI18n")
    private void resetUI() {
        counterView.setText(counterTeam1.toString());
        counterView2.setText(counterTeam2.toString());
        Log.d(TAG, "resetUI");
    }
}
