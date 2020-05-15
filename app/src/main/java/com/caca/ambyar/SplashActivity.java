package com.caca.ambyar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    //Nama : Ananda Salsabila
    //Nim : 10117133
    //Kelas : AKB

    //Tanggal pengerjaan 6 mei 2020

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int loading = 3000; //1 Detik

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, SliderActivty.class);
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }, loading);
    }
}
