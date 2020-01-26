package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;


public class gym extends AppCompatActivity {

    private RecyclerView mGymList;
    private ArrayList<Data> arrayList;
    private FirebaseRecyclerOptions<Data>options;
    private FirebaseRecyclerAdapter<Data, GymViewHolder> adapter;
    private DatabaseReference mDatabase;
    private Uri u;
    private Context c;

    @Override
    protected void onStart(){
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
        setContentView(R.layout.activity_gym);


        arrayList = new ArrayList<Data>();

        mGymList=(RecyclerView)findViewById(R.id.rv_main);
        mGymList.setHasFixedSize(true);
        mGymList.setLayoutManager(new LinearLayoutManager(this));

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Detail-GYM");
        mDatabase.keepSynced(true);
        options = new FirebaseRecyclerOptions.Builder<Data>().setQuery(mDatabase,Data.class).build();
        adapter = new FirebaseRecyclerAdapter<Data, GymViewHolder>(options){
            @Override
            protected void onBindViewHolder(@NonNull GymViewHolder gymViewHolder, int i, @NonNull final Data Data){
                PicassoGym.downloadImage(c,Data.getImgUrl(), gymViewHolder.img);
                gymViewHolder.nama.setText(Data.getNamaGym());
                gymViewHolder.alamat.setText(Data.getAlamatGym());
                gymViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(gym.this,profil_gym.class);
                        i.putExtra("nama", Data.getNamaGym());
                        i.putExtra("alamat",Data.getAlamatGym());
                        i.putExtra("notelp",Data.getTeleponGym());
                        i.putExtra("pendaftaran",Data.getBiaya_pendaftaran());
                        i.putExtra("insidental",Data.getBiaya_insindental());
                        i.putExtra("biaya_1",Data.getBiaya_satuBulan());
                        i.putExtra("biaya_2",Data.getBiaya_duaBulan());
                        i.putExtra("biaya_3",Data.getBiaya_tigaBulan());
                        i.putExtra("biaya_6",Data.getEnamBulan());
                        i.putExtra("biaya_perpanjangan",Data.getBiayaPerpanjangan());
                        i.putExtra("img",Data.getImgUrl());
                        startActivity(i);
                    }
                });

        }

        @NonNull
        @Override
        public GymViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
                return new GymViewHolder(LayoutInflater.from(gym.this).inflate(R.layout.daftar_gym,parent,false));
        }
    };

        mGymList.setAdapter(adapter);


    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseRecyclerAdapter<Data,DataViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Data, DataViewHolder>
//                (Data.class,R.layout.daftar_gym,DataViewHolder.class,mDatabase) {
//            @Override
//            protected void populateViewHolder(DataViewHolder dataViewHolder, Data data, int i) {
//                dataViewHolder.setTitle(data.getNamaGym());
//                dataViewHolder.setAlamat(data.getAlamatGym());
//            }
//        };
//
//        mGymList.setAdapter(firebaseRecyclerAdapter);
//
//    }
//
//    public static class DataViewHolder extends RecyclerView.ViewHolder
//    {
//        View mView;
//        public DataViewHolder(View itemView)
//        {
//            super(itemView);
//            mView=itemView;
//        }
//        public void setTitle(String title){
//            TextView postTitle=(TextView)mView.findViewById(R.id.tvNama);
//            postTitle.setText(title);
//        }
//        public void setAlamat(String ala){
//            TextView postAlamat=(TextView)mView.findViewById(R.id.tvAlamat);
//            postAlamat.setText(ala);
//        }
//    }


}
