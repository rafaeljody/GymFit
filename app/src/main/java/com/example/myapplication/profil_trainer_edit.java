package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class profil_trainer_edit extends AppCompatActivity {

    TextView ttNama,ttSpesial,ttSosmed,ttHomeBase,
            ttPengalaman,ttArea,ttSertifikasi,ttTarif,ttNoTelp,ttPendidikan;
    ImageView tImg;

    Button bteditData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_trainer_edit);

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
        String img=getIntent().getStringExtra("img");

        ttNama =(TextView)findViewById(R.id.tvNama);
        ttSpesial =(TextView)findViewById(R.id.tvKeahlian);
        ttSosmed =(TextView)findViewById(R.id.tvSosmed);
        ttHomeBase=(TextView)findViewById(R.id.tvHomeBase);
        ttPengalaman=(TextView)findViewById(R.id.tvPengalaman);
        ttArea=(TextView)findViewById(R.id.tvOnCall);
        ttSertifikasi=(TextView)findViewById(R.id.tvSertifikasi);
        ttTarif=(TextView)findViewById(R.id.tvTarif);
        ttNoTelp=(TextView)findViewById(R.id.tvNoHp);
        ttPendidikan=(TextView)findViewById(R.id.tv_pendaftaran);
        tImg=(ImageView)findViewById(R.id.profileTrainer);

        bteditData = (Button) findViewById(R.id.btn_editSubmit);


        ttNama.setText(nama);
        ttSpesial.setText(spesial);
        ttSosmed.setText(sosmed);
        ttHomeBase.setText(homebase);
        ttPengalaman.setText(pengalaman);
        ttArea.setText(area);
        ttSertifikasi.setText(sertifikasi);
        ttTarif.setText(tarif);
        ttNoTelp.setText(notelp);
        ttPendidikan.setText(pendidikan);

        Picasso.get().load(img).into(tImg);

    }



}
