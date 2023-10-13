package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private calculatorFragment fragCalculator;
    private avarageFragment fragAvarage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragCalculator = new calculatorFragment();
        fragAvarage = new avarageFragment();
    }

    public void setFragCalculator(View view){
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameL01, fragCalculator);
        fm.commit();
    }

    public void setFragAvarage(View view){
        FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
        fm.replace(R.id.frameL01, fragAvarage);
        fm.commit();
    }
}