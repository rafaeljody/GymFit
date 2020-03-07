package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class profil_trainer extends AppCompatActivity {


    TextView tNama,tSpesial,tSosmed,tHomeBase,tPengalaman,tArea,tSertifikasi,tTarif,tNoTelp,tPendidikan;
    ImageView tImg;
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
        String pendidikan=getIntent().getStringExtra("pendidikan");
        String img=getIntent().getStringExtra("img");

        tNama =(TextView)findViewById(R.id.tvNama);
        tSpesial =(TextView)findViewById(R.id.tvKeahlian);
        tSosmed =(TextView)findViewById(R.id.tvSosmed);
        tHomeBase=(TextView)findViewById(R.id.tvHomeBase);
        tPengalaman=(TextView)findViewById(R.id.tvPengalaman);
        tArea=(TextView)findViewById(R.id.tvOnCall);
        tSertifikasi=(TextView)findViewById(R.id.tvSertifikasi);
        tTarif=(TextView)findViewById(R.id.tvTarif);
        tPendidikan=(TextView)findViewById(R.id.tv_pendaftaran);
        tImg=(ImageView)findViewById(R.id.profileTrainer);


        tNama.setText(nama);
        tSpesial.setText(spesial);
        tSosmed.setText(sosmed);
        tHomeBase.setText(homebase);
        tPengalaman.setText(pengalaman);
        tArea.setText(area);
        tSertifikasi.setText(sertifikasi);
        tTarif.setText(tarif);
        tPendidikan.setText(pendidikan);

        Picasso.get().load(img).into(tImg);
    }

    public void nope (View view){
        try {
            String text = "Terimakasih telah menggunakan GYM FIT, silakan bertanya: \n\n";// Replace with your message.

            String toNumber = "6285643377456"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
