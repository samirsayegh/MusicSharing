package com.project.afinal.bts.musicsharing.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.afinal.bts.musicsharing.NavigationManager;
import com.project.afinal.bts.musicsharing.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NavigationManager.navigate(this, new FeelingsFragment(), true);
    }
}
