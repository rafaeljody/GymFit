package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class form_edit_data_trainer extends AppCompatActivity {

    DatabaseReference root;

    EditText edtNama_trainer, edtPend_formal, edtGym_home, edtOn_call,
            edtNomor_telp, edtSosmed, edtPengalaman, edtTarif, edtSertifikasi, edtKeahlian;

    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit_data_trainer);

        edtNama_trainer = findViewById(R.id.edt_editNamaTrainer);
        edtPend_formal = findViewById(R.id.edt_editPend);
        edtGym_home = findViewById(R.id.edt_editHomeBase);
        edtOn_call = findViewById(R.id.edt_editOnCall);
        edtNomor_telp = findViewById(R.id.edt_editNomorTelp);
        edtSosmed = findViewById(R.id.edt_Medsos);
        edtPengalaman = findViewById(R.id.edt_editPengKerja);
        edtTarif = findViewById(R.id.edt_editTarifPert);
        edtSertifikasi = findViewById(R.id.edt_editSertifikasi);
        edtKeahlian = findViewById(R.id.edt_editKeahlian);


        root = FirebaseDatabase.getInstance().getReference().child("DATA TRAINER");
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String nama_trainer = dataSnapshot.child("nama_trainer").getValue().toString();
                String pendidikan_formal = dataSnapshot.child("pendidikan_formal").getValue().toString();
                String gym_home = dataSnapshot.child("gym_home").getValue().toString();
                String onCall = dataSnapshot.child("on_call_area").getValue().toString();
                String no_telp = dataSnapshot.child("no_telp").getValue().toString();
                String medsos = dataSnapshot.child("akun_sosmed").getValue().toString();
                String pengalaman_kerja = dataSnapshot.child("pengalaman_kerja").getValue().toString();
                String tarif_pertemuan = dataSnapshot.child("tarif_pertemuan").getValue().toString();
                String sertifikasi = dataSnapshot.child("sertifikasi").getValue().toString();
                String keahlian = dataSnapshot.child("keahlian").getValue().toString();

                edtNama_trainer.setText(nama_trainer);
                edtPend_formal.setText(pendidikan_formal);
                edtGym_home.setText(gym_home);
                edtOn_call.setText(onCall);
                edtNomor_telp.setText(no_telp);
                edtSosmed.setText(medsos);
                edtPengalaman.setText(pengalaman_kerja);
                edtTarif.setText(tarif_pertemuan);
                edtSertifikasi.setText(sertifikasi);
                edtKeahlian.setText(keahlian);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama_trainer, pendidikan_formal, gym_home, onCall, no_telp,
                        medsos, pengalaman_kerja, tarif_pertemuan, sertifikasi, keahlian;

                nama_trainer = edtNama_trainer.getText().toString().trim();
                pendidikan_formal = edtPend_formal.getText().toString().trim();
                gym_home = edtGym_home.getText().toString().trim();
                onCall = edtOn_call.getText().toString().trim();
                no_telp = edtNomor_telp.getText().toString().trim();
                medsos = edtSosmed.getText().toString().trim();
                pengalaman_kerja = edtPengalaman.getText().toString().trim();
                tarif_pertemuan = edtTarif.getText().toString().trim();
                sertifikasi = edtSertifikasi.getText().toString().trim();
                keahlian = edtKeahlian.getText().toString().trim();

                if(!TextUtils.isEmpty(nama_trainer)){
                    root.child("nama_trainer").setValue(nama_trainer);
                }
                if(!TextUtils.isEmpty(pendidikan_formal)){
                    root.child("pendidikan_formal").setValue(pendidikan_formal);
                }
                if(!TextUtils.isEmpty(gym_home)){
                    root.child("gym_home").setValue(gym_home);
                }
                if(!TextUtils.isEmpty(onCall)){
                    root.child("on_call_area").setValue(onCall);
                }
                if(!TextUtils.isEmpty(no_telp)){
                    root.child("nomor_telp").setValue(no_telp);
                }
                if(!TextUtils.isEmpty(medsos)){
                    root.child("akun_sosmed").setValue(medsos);
                }
                if(!TextUtils.isEmpty(pengalaman_kerja)){
                    root.child("pengalaman_kerja").setValue(pengalaman_kerja);
                }
                if(!TextUtils.isEmpty(tarif_pertemuan)){
                    root.child("tarif_pertemuan").setValue(tarif_pertemuan);
                }
                if(!TextUtils.isEmpty(sertifikasi)){
                    root.child("sertifikasi").setValue(sertifikasi);
                }
                if(!TextUtils.isEmpty(keahlian)){
                    root.child("keahlian").setValue(keahlian);
                }

                startActivity(new Intent(getApplicationContext(), AdminActivity.class));
                finish();

            }
        });
    }
}
