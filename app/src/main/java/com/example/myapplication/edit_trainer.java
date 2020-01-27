package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class edit_trainer extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<personalTrainer> arrayList;
    private FirebaseRecyclerOptions<personalTrainer> option;
    private FirebaseRecyclerAdapter<personalTrainer,TrainerViewHolder> adapter;
    private DatabaseReference mDatabase;
    private Uri u;
    private Context c;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        recyclerView = findViewById(R.id.rv_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList = new ArrayList<personalTrainer>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("DATA TRAINER");
        mDatabase.keepSynced(true);
        option = new FirebaseRecyclerOptions.Builder<personalTrainer>().setQuery(mDatabase, personalTrainer.class).build();
        adapter = new FirebaseRecyclerAdapter<personalTrainer, TrainerViewHolder>(option) {
            @Override
            protected void onBindViewHolder(@NonNull final TrainerViewHolder trainerViewHolder, int i, @NonNull final personalTrainer personalTrainer) {
                PicassoTrainer.downloadImage(c, personalTrainer.getImgUrl(), trainerViewHolder.img);
                trainerViewHolder.nama.setText(personalTrainer.getNama_trainer());
                trainerViewHolder.splesialisasi.setText(personalTrainer.getKeahlian());
                trainerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent a = new Intent(edit_trainer.this, profil_trainer_edit.class);
                        a.putExtra("nama", personalTrainer.getNama_trainer());
                        a.putExtra("spesialisasi", personalTrainer.getKeahlian());
                        a.putExtra("pendidikan", personalTrainer.getPendidikan_formal());
                        a.putExtra("sosmed", personalTrainer.getAkun_sosmed());
                        a.putExtra("homebase", personalTrainer.getGym_home());
                        a.putExtra("pengalaman", personalTrainer.getPengalaman_kerja());
                        a.putExtra("area", personalTrainer.getOn_call_area());
                        a.putExtra("sertifikasi", personalTrainer.getSertifikasi());
                        a.putExtra("tarif", personalTrainer.getTarif_pertemuan());
                        a.putExtra("notelp", personalTrainer.getNomor_telp());
                        a.putExtra("img", personalTrainer.getImgUrl());
                        startActivity(a);


                    }
                });

            }

            @NonNull
            @Override
            public TrainerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                return new TrainerViewHolder(LayoutInflater.from(edit_trainer.this).inflate(R.layout.daftar_trainer, parent, false));
            }
        };
        recyclerView.setAdapter(adapter);
    }
}
