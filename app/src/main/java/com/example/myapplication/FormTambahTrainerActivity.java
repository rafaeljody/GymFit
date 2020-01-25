package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormTambahTrainerActivity extends AppCompatActivity {

    DatabaseReference database; // untuk mengambil root pada database

    EditText etNamaTrainer, etPendidikan, etGym,
            etOn, etTelepon, etSosmed,etPengalaman, etTarif,
            etSertifikasi, etAhli;

    Button btUpload, btSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_tambah_trainer);

        //Inisialisasi Data Trainer
        etNamaTrainer   = (EditText) findViewById(R.id.edt_NamaTrainer);
        etPendidikan    = (EditText) findViewById(R.id.edt_Pend);
        etGym           = (EditText) findViewById(R.id.edt_HomeBase);
        etOn            = (EditText) findViewById(R.id.edt_OnCall);
        etTelepon       = (EditText) findViewById(R.id.edt_NomorTelp);
        etSosmed        = (EditText) findViewById(R.id.edt_Medsos);
        etPengalaman    = (EditText) findViewById(R.id.edt_PengKerja);
        etTarif         = (EditText) findViewById(R.id.edt_TarifPert);
        etSertifikasi   = (EditText) findViewById(R.id.edt_Sertifikasi);
        etAhli          = (EditText) findViewById(R.id.edt_Keahlian);

        // inisialisasi button submit dan upload
        btUpload        = (Button) findViewById(R.id.btn_UploadTrainer);
        btSubmit        = (Button) findViewById(R.id.btn_submit);

        // inisialisasi Firebase
        database = FirebaseDatabase.getInstance().getReference();

        //onClick pada button submit
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personalTrainer(new personalTrainer(
                        etNamaTrainer.getText().toString(),
                        etPendidikan.getText().toString(),
                        etGym.getText().toString(),
                        etOn.getText().toString(),
                        etTelepon.getText().toString(),
                        etSosmed.getText().toString(),
                        etPengalaman.getText().toString(),
                        etTarif.getText().toString(),
                        etSertifikasi.getText().toString(),
                        etAhli.getText().toString()));
            }
        });

    }

    public void personalTrainer(personalTrainer personal_trainer){
        database.child("DATA TRAINER").push().setValue(personal_trainer).addOnSuccessListener(this,
                new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
               etNamaTrainer.setText("");
               etPendidikan.setText("");
               etGym.setText("");
               etOn.setText("");
               etTelepon.setText("");
               etSosmed.setText("");
               etPengalaman.setText("");
               etTarif.setText("");
               etSertifikasi.setText("");
               etAhli.setText("");

                Snackbar.make(findViewById(R.id.btn_submit),"Data Berhasil Ditambahkan", Snackbar.LENGTH_LONG).show();

            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, FormTambahTrainerActivity.class);
    }

}
