package com.example.googleafricascholarship.ui.activity.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.googleafricascholarship.R;
import com.example.googleafricascholarship.ui.activity.main.MainActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}