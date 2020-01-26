package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profil_gym extends AppCompatActivity {

    TextView tnama_gym, talamat_gym, tnoTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_gym);

        String nama_gym = getIntent().getStringExtra("nama");
        String alamat_gym = getIntent().getStringExtra("alamat");
        String no_telp = getIntent().getStringExtra("notelp");

        tnama_gym= (TextView) findViewById(R.id.tvNama);
        talamat_gym = (TextView) findViewById(R.id.tvAlamat);
        tnoTelp = (TextView) findViewById(R.id.tvNoTelp);

        tnama_gym.setText(nama_gym);
        talamat_gym.setText(alamat_gym);
        tnoTelp.setText(no_telp);





    }
}
