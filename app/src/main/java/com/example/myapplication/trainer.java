package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;

public class trainer extends AppCompatActivity {
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

        mDatabase= FirebaseDatabase.getInstance().getReference().child("DATA TRAINER");
        mDatabase.keepSynced(true);
        option = new FirebaseRecyclerOptions.Builder<personalTrainer>().setQuery(mDatabase,personalTrainer.class).build();
        adapter = new FirebaseRecyclerAdapter<personalTrainer, TrainerViewHolder>(option) {
            @Override
            protected void onBindViewHolder(@NonNull TrainerViewHolder trainerViewHolder, int i, @NonNull final personalTrainer personalTrainer) {
                PicassoTrainer.downloadImage(c,personalTrainer.getImgUrl(),trainerViewHolder.img);
                trainerViewHolder.nama.setText(personalTrainer.getNama_trainer());
                trainerViewHolder.splesialisasi.setText(personalTrainer.getKeahlian());
                trainerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(trainer.this,profil_trainer.class);
                        i.putExtra("nama", personalTrainer.getNama_trainer());
                        i.putExtra("spesialisasi",personalTrainer.getKeahlian());
                        i.putExtra("pendidikan",personalTrainer.getPendidikan_formal());
                        i.putExtra("sosmed",personalTrainer.getAkun_sosmed());
                        i.putExtra("homebase",personalTrainer.getGym_home());
                        i.putExtra("pengalaman",personalTrainer.getPengalaman_kerja());
                        i.putExtra("area",personalTrainer.getOn_call_area());
                        i.putExtra("sertifikasi",personalTrainer.getSertifikasi());
                        i.putExtra("tarif",personalTrainer.getTarif_pertemuan());
                        i.putExtra("notelp",personalTrainer.getNomor_telp());
                        i.putExtra("img",personalTrainer.getImgUrl());
                        startActivity(i);
                    }
                });
            }

            @NonNull
            @Override
            public TrainerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                return new TrainerViewHolder(LayoutInflater.from(trainer.this).inflate(R.layout.daftar_trainer,parent,false));
            }
        };


        recyclerView.setAdapter(adapter );
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trainer);
//
//        mDatabase= FirebaseDatabase.getInstance().getReference().child("DATA TRAINER");
//        mDatabase.keepSynced(true);
//
//        mTrainerList=(RecyclerView)findViewById(R.id.rv_main);
//        mTrainerList.setHasFixedSize(true);
//        mTrainerList.setLayoutManager(new LinearLayoutManager(this));
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseRecyclerAdapter<personalTrainer, trainer.TrainerViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<personalTrainer, trainer.TrainerViewHolder>
//                (personalTrainer.class,R.layout.daftar_trainer, trainer.TrainerViewHolder.class,mDatabase) {
//            @Override
//            protected void populateViewHolder(trainer.TrainerViewHolder trainerViewHolder, personalTrainer pt, int i) {
//                trainerViewHolder.setTrainer(pt.getNama_trainer());
//                trainerViewHolder.setSpesialisasi(pt.getKeahlian());
//                trainerViewHolder.setImage(getApplicationContext(),pt.getImgUrl());
//            }
//        };
//
//        mTrainerList.setAdapter(firebaseRecyclerAdapter);
//    }
//
//    public static class TrainerViewHolder extends RecyclerView.ViewHolder
//    {
//        View mView;
//        public TrainerViewHolder(View itemView)
//        {
//            super(itemView);
//            mView=itemView;
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Intent i = new Intent(view.getContext(),profil_trainer.class);
//                    view.getContext().startActivities(i);
//                }
//            });
//
//        }
//        public void setTrainer(String title){
//            TextView postTrainer=(TextView)mView.findViewById(R.id.tvNama);
//            postTrainer.setText(title);
//        }
//        public void setSpesialisasi(String spe){
//            TextView postKeahlian=(TextView)mView.findViewById(R.id.tvSpesialisasi);
//            postKeahlian.setText(spe);
//        }
//        public void setImage(Context ctx, String image){
//            ImageView postImage=(ImageView)mView.findViewById(R.id.imgTrainer);
//            Picasso.get().load(image).into(postImage);
//        }
//    }


}
