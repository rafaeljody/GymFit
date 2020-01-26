package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class profil_trainer extends AppCompatActivity {

    TextView tNama,tSpesial,tSosmed,tHomeBase,tPengalaman,tArea,tSertifikasi,tTarif,tNoTelp,tPendidikan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_trainer);

        String nama=getIntent().getStringExtra("nama");
        String spesial=getIntent().getStringExtra("spesialisasi");
        String sosmed=getIntent().getStringExtra("sosmed");
        String homebase=getIntent().getStringExtra("homebase");
        String pengalaman=getIntent().getStringExtra("pengalaman");
        String area=getIntent().getStringExtra("area");
        String sertifikasi=getIntent().getStringExtra("sertifikasi");
        String tarif=getIntent().getStringExtra("tarif");
        String notelp=getIntent().getStringExtra("notelp");
        String pendidikan=getIntent().getStringExtra("pendidikan");

        tNama =(TextView)findViewById(R.id.tvNama);
        tSpesial =(TextView)findViewById(R.id.tvKeahlian);
        tSosmed =(TextView)findViewById(R.id.tvSosmed);
        tHomeBase=(TextView)findViewById(R.id.tvHomeBase);
        tPengalaman=(TextView)findViewById(R.id.tvPengalaman);
        tArea=(TextView)findViewById(R.id.tvOnCall);
        tSertifikasi=(TextView)findViewById(R.id.tvSertifikasi);
        tTarif=(TextView)findViewById(R.id.tvTarif);
        tNoTelp=(TextView)findViewById(R.id.tvNoHp);
        tPendidikan=(TextView)findViewById(R.id.tvPendidikan);

        tNama.setText(nama);
        tSpesial.setText(spesial);
        tSosmed.setText(sosmed);
        tHomeBase.setText(homebase);
        tPengalaman.setText(pengalaman);
        tArea.setText(area);
        tSertifikasi.setText(sertifikasi);
        tTarif.setText(tarif);
        tNoTelp.setText(notelp);
        tPendidikan.setText(pendidikan);
    }
}
