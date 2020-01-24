package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PilihTambahActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_tambah);
    }

    public void formgym(View view){
        Intent intent = new Intent(PilihTambahActivity.this, FormTambahGymActivity.class);
        startActivity(intent);
    }

    public void formtrainer(View view){
        Intent intent = new Intent(PilihTambahActivity.this, FormTambahTrainerActivity.class);
        startActivity(intent);
    }
}
