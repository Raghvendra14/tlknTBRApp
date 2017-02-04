package com.example.android.tlkntbrapp;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            View shadowView = findViewById(R.id.shadow_view);
            shadowView.setVisibility(View.VISIBLE);
        }

        CircleImageView userIcon = (CircleImageView) findViewById(R.id.user_icon);
        userIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, R.string.user_content, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView dialerIcon = (ImageView) findViewById(R.id.dialer_icon);
        dialerIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, R.string.dialer, Toast.LENGTH_SHORT).show();
            }
        });

        if (!Utils.isNetworkAvailable(context)) {
            Toast.makeText(context, R.string.connection_required, Toast.LENGTH_SHORT).show();
        }
    }
}
