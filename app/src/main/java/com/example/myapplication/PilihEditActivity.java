package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PilihEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_edit);
    }

    public void gymi(View view){
        Intent intent = new Intent(PilihEditActivity.this, gym.class);
        startActivity(intent);
    }

    public void traineri(View view){
        Intent intent = new Intent(PilihEditActivity.this, trainer.class);
        startActivity(intent);
    }
}
