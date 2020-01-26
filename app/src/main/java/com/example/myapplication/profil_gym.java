package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class profil_gym extends AppCompatActivity {


    TextView tnama_gym, talamat_gym, tnoTelp,
            tPendaftaran,tbiaya_satu,tbiaya_dua,
            tbiaya_tiga,tbiaya_enam, tperpanjangan,tinsidental,
    t;

    ImageView tImg_gym, tImg_trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_gym);

        String nama_gym = getIntent().getStringExtra("namagym");
        String alamat_gym = getIntent().getStringExtra("alamatgym");
        String telepon_gym = getIntent().getStringExtra("teleponGym");
        String img_gym = getIntent().getStringExtra("img_gym");
        String pendaftaran_mb = getIntent().getStringExtra("pendaftaranMb");
        String insidental_mb = getIntent().getStringExtra("insidentalMb");
        String biaya_satu = getIntent().getStringExtra("biaya_satu");
        String biaya_dua = getIntent().getStringExtra("biaya_dua");
        String biaya_tiga = getIntent().getStringExtra("biaya_tiga");
        String biaya_enam = getIntent().getStringExtra("biaya_enam");
        String perpanjangan = getIntent().getStringExtra("perpanjangan");


        tnama_gym= (TextView) findViewById(R.id.tvNamaGym);
        talamat_gym = (TextView) findViewById(R.id.tvAlamat);
        tnoTelp = (TextView) findViewById(R.id.tvNoTelp);
        tImg_gym = (ImageView) findViewById(R.id.imgGym);

        tPendaftaran = (TextView) findViewById(R.id.tv_pendaftaran);
        tbiaya_satu = (TextView) findViewById(R.id.tv_satubulan);
        tbiaya_dua = (TextView) findViewById(R.id.tv_duabulan);
        tbiaya_tiga = (TextView)findViewById(R.id.tv_tigabulan);
        tbiaya_enam = (TextView) findViewById(R.id.tv_enambulan);
        tinsidental = (TextView) findViewById(R.id.tv_insindental);
        tperpanjangan =  (TextView) findViewById(R.id.tv_perpanjangan);






        tnama_gym.setText(nama_gym) ;
        talamat_gym.setText(alamat_gym);
        tnoTelp.setText(telepon_gym);

        tPendaftaran.setText("Harga Pendaftaran : "+ pendaftaran_mb);
        tinsidental.setText("Harga Insidental : "+insidental_mb);
        tbiaya_satu.setText("Harga 1 Bulan : "+biaya_satu);
        tbiaya_dua.setText("Harga 2 Bulan : " +biaya_dua);
        tbiaya_tiga.setText("Harga 3 Bulan : "+biaya_tiga);
        tbiaya_enam.setText("Harga 6 Bulan : "+biaya_enam);
        tperpanjangan.setText("Harga Perpanjangan : "+perpanjangan);

        // paket Personal Trainer



        Picasso.get().load(img_gym).into(tImg_gym);



    }
}
