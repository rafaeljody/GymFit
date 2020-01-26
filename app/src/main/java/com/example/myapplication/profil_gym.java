package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class profil_gym extends AppCompatActivity {

    TextView tnama_gym, talamat_gym, tnoTelp;
    ImageView tImg_gym, tImg_trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_gym);

        String nama_gym = getIntent().getStringExtra("nama_gym");
        String alamat_gym = getIntent().getStringExtra("alamat_gym");


        tnama_gym= (TextView) findViewById(R.id.tvNama);
        talamat_gym = (TextView) findViewById(R.id.tvAlamat);


        tnama_gym.setText(nama_gym);
        talamat_gym.setText(alamat_gym);



    }
}
