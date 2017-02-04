package com.example.android.tlkntbrapp;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            View shadowView = findViewById(R.id.shadow_view);
            shadowView.setVisibility(View.VISIBLE);
        }
    }

}
