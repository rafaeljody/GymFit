package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormTambahGymActivity extends AppCompatActivity {

    DatabaseReference database; // untuk mengambil root pada database

    Button btUpload,btSubmitDB,btUploadMesin; //button upload dan submit
    EditText etNamaGym, etAlamatGym, etNomorHP; // Detail GYM
    EditText etPendaftar, etInsidental, etBiaya1, etBiaya2, etBiaya3, etBiaya6, etPerpanjangan; // Paket Membership
    EditText etTemu5, etTemu10, etTemu15, etTemu20; // Biaya Personal Trainer

    //checkbox fasilitas Gym
    CheckBox cb_ac,cb_kipas,cb_handuk, cb_Air, cb_kamar_mandi,
    cb_ruangLoker, cb_sauna, cb_wifi, cb_kolamRenang;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah_gym);

        //inisialisasi Detail GYM
        etNamaGym       = (EditText) findViewById(R.id.edt_NamaGym);
        etAlamatGym     = (EditText) findViewById(R.id.edt_Alamat);
        etNomorHP       = (EditText) findViewById(R.id.edt_NoTelp);

        //inisialisasi Paket Membership
        etPendaftar     = (EditText) findViewById(R.id.edt_pktPendaftaran);
        etInsidental    = (EditText) findViewById(R.id.edt_pktInsidental);
        etBiaya1        = (EditText) findViewById(R.id.edt_pktSatubln);
        etBiaya2        = (EditText) findViewById(R.id.edt_pktDuabln);
        etBiaya3        = (EditText) findViewById(R.id.edt_pktTigabln);
        etBiaya6        = (EditText) findViewById(R.id.edt_pktEnambln);
        etPerpanjangan  = (EditText) findViewById(R.id.edt_pktPerpanjangan);

        //inisialisasi Biaya Personal Trainer
        etTemu5         = (EditText) findViewById(R.id.edt_byLimaPert);
        etTemu10        = (EditText) findViewById(R.id.edt_bySepulPert);
        etTemu15        = (EditText) findViewById(R.id.edt_byLimabelsPert);
        etTemu20        = (EditText) findViewById(R.id.edt_byDuapulPert);



        //inisialisasi Button Submit dan Upload
        btSubmitDB      = (Button) findViewById(R.id.btn_submit);
        btUpload        = (Button) findViewById(R.id.btn_UploadGym);
        btUploadMesin   = (Button) findViewById(R.id.btn_UploadMesin);

        // Inisialisasi Fireb,ase
        database = FirebaseDatabase.getInstance().getReference().child("GYM FIT");

        //Onclick pada Button Submit
        btSubmitDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitData(new Data(
                        etNamaGym.getText().toString(),
                        etAlamatGym.getText().toString(),etNomorHP.getText().toString(),
                        etPendaftar.getText().toString(),etInsidental.getText().toString(),
                        etBiaya1.getText().toString(),etBiaya2.getText().toString(),
                        etBiaya3.getText().toString(),etBiaya6.getText().toString(),
                        etPerpanjangan.getText().toString(),etTemu5.getText().toString(),
                        etTemu10.getText().toString(),etTemu15.getText().toString(),
                        etTemu20.getText().toString()));

                if (cb_ac.isChecked()){
                    database.child("Fasilitas-1").setValue("Air Conditioner");
                }
                if (cb_kipas.isChecked()){
                    database.child("Fasilitas-2").setValue("Kipas Angin");
                }
                if (cb_handuk.isChecked()){
                    database.child("Fasilitas-3").setValue("Handuk");
                }
                if (cb_Air.isChecked()){
                    database.child("Fasilitas-4").setValue("Air Minum");
                }
                if (cb_kamar_mandi.isChecked()){
                    database.child("Fasilitas-5").setValue("Kamar Mandi");
                }
                if (cb_ruangLoker.isChecked()){
                    database.child("Fasilitas-6").setValue("Ruang Loker");
                }
            }
        });

    }

    public void submitData (Data data){
        database.child("Detail-GYM").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                // set data Detail gym
                etNamaGym.setText("");
                etAlamatGym.setText("");
                etNomorHP.setText("");

                //set data paket membership
                etPendaftar.setText("");
                etInsidental.setText("");
                etBiaya1.setText("");
                etBiaya2.setText("");
                etBiaya3.setText("");
                etBiaya6.setText("");
                etPerpanjangan.setText("");

                //set data biaya personal trainer
                etTemu5.setText("");
                etTemu10.setText("");
                etTemu15.setText("");
                etTemu20.setText("");


                Snackbar.make(findViewById(R.id.btn_submit),"Data Berhasil Ditambahkan", Snackbar.LENGTH_LONG).show();
            }
        });

        database.child("Fasilitas-GYM").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

            }
        });
//        database.child("Paket-Membership").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        });
//        database.child("Biaya Personal Trainer").push().setValue(data).addOnSuccessListener(this, new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//
//            }
//        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FormTambahGymActivity.class);
    }


}
