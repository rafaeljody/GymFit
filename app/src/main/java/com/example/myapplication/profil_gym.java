package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class profil_gym extends AppCompatActivity {


    TextView tnama_gym, talamat_gym, tnoTelp,
            tPendaftaran,tbiaya_satu,tbiaya_dua,
            tbiaya_tiga,tbiaya_enam, tperpanjangan,tinsidental,
            tTemu5, tTemu10, tTemu15, tTemu20,tPT,
            tfasilitas_gym,tkelas_gym,tperalatan_gym,tgym_machine, tKeunggulan_gym, tNoHp;

    ImageView tImg_gym, tImg_trainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_gym);


        TextView tNoHp = findViewById(R.id.tvNoHp);


        String nama_gym = getIntent().getStringExtra("namagym");
        String alamat_gym = getIntent().getStringExtra("alamatgym");
        String img_gym = getIntent().getStringExtra("img_gym");

        String pendaftaran_mb = getIntent().getStringExtra("pendaftaranMb");
        String insidental_mb = getIntent().getStringExtra("insidentalMb");
        String biaya_satu = getIntent().getStringExtra("biaya_satu");
        String biaya_dua = getIntent().getStringExtra("biaya_dua");
        String biaya_tiga = getIntent().getStringExtra("biaya_tiga");
        String biaya_enam = getIntent().getStringExtra("biaya_enam");
        String perpanjangan = getIntent().getStringExtra("perpanjangan");

        String temu_lima = getIntent().getStringExtra("temu5");
        String temu_sepuluh = getIntent().getStringExtra("temu10");
        String temu_limbabelas = getIntent().getStringExtra("temu15");
        String temu_duapuluh = getIntent().getStringExtra("temu20");

        String personalt = getIntent().getStringExtra("trainerGym");

        String fasilitas_gym = getIntent().getStringExtra("fasilitas_gym");
        String kelas_gym = getIntent().getStringExtra("kelas_gym");
        String peralatan_gym = getIntent().getStringExtra("peralatan_gym");
        String gym_machine = getIntent().getStringExtra("gym_machine");
        String keunggulan_gym = getIntent().getStringExtra("keunggulan_gym");


        tnama_gym   = (TextView) findViewById(R.id.tvNamaGym);
        talamat_gym = (TextView) findViewById(R.id.tvAlamat);
        tImg_gym    = (ImageView) findViewById(R.id.imgGym);

        tPendaftaran    = (TextView) findViewById(R.id.tv_pendaftaran);
        tbiaya_satu     = (TextView) findViewById(R.id.tv_satubulan);
        tbiaya_dua      = (TextView) findViewById(R.id.tv_duabulan);
        tbiaya_tiga     = (TextView)findViewById(R.id.tv_tigabulan);
        tbiaya_enam     = (TextView) findViewById(R.id.tv_enambulan);
        tinsidental     = (TextView) findViewById(R.id.tv_insindental);
        tperpanjangan   =  (TextView) findViewById(R.id.tv_perpanjangan);

        tTemu5  = (TextView) findViewById(R.id.tv5Temu);
        tTemu10 = (TextView) findViewById(R.id.tv_10Temu);
        tTemu15 = (TextView) findViewById(R.id.tv15Temu);
        tTemu20 = (TextView) findViewById(R.id.tv20Temu);
        tPT = (TextView) findViewById(R.id.tvTampilPT);
        tfasilitas_gym = (TextView) findViewById(R.id.tvFasilitas);
        tkelas_gym = (TextView) findViewById(R.id.tvKelas);
        tperalatan_gym = (TextView) findViewById(R.id.tvPeralatanKebug);
        tgym_machine = (TextView) findViewById(R.id.tvGymMachine);
        tKeunggulan_gym = (TextView) findViewById(R.id.tvKeunggulan);


        tnama_gym.setText(nama_gym) ;
        talamat_gym.setText(alamat_gym);

        //paket membership
        tPendaftaran.setText("Harga Pendaftaran : "+ pendaftaran_mb);
        tinsidental.setText("Harga Insidental : "+insidental_mb);
        tbiaya_satu.setText("Harga 1 Bulan : "+biaya_satu);
        tbiaya_dua.setText("Harga 2 Bulan : " +biaya_dua);
        tbiaya_tiga.setText("Harga 3 Bulan : "+biaya_tiga);
        tbiaya_enam.setText("Harga 6 Bulan : "+biaya_enam);
        tperpanjangan.setText("Harga Perpanjangan : "+perpanjangan);

        // paket Personal Trainer
        tTemu5.setText ("Harga  5x Pertemuan : "+temu_lima);
        tTemu10.setText("Harga 10x Pertemuan: "+temu_sepuluh);
        tTemu15.setText("Harga 15x Pertemuan: "+temu_limbabelas);
        tTemu20.setText("Harga 20x Pertemuan: "+temu_duapuluh);
        tPT.setText(personalt);
        tfasilitas_gym.setText(fasilitas_gym);
        tkelas_gym.setText(kelas_gym);
        tperalatan_gym.setText(peralatan_gym);
        tgym_machine.setText(gym_machine);
        tKeunggulan_gym.setText(keunggulan_gym);


        Picasso.get().load(img_gym).into(tImg_gym);



    }

    public void nope(View view){
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
