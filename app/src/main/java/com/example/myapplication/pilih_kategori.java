package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class pilih_kategori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_kategori);


    }
    public void eduUmum(View view){
        Intent intent = new Intent(pilih_kategori.this, TipsActivity.class);
        startActivity(intent);
    }

    public void eduLatihan(View view){
        Intent intent = new Intent(pilih_kategori.this, tips_latihan.class);
        startActivity(intent);
    }

}
