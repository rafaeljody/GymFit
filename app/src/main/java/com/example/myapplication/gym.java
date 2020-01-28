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
            protected void onBindViewHolder(@NonNull GymViewHolder gymViewHolder, int i, @NonNull final Data data){
                PicassoGym.downloadImage(c,data.getImgUrl(), gymViewHolder.img);
                gymViewHolder.nama_gym.setText(data.getNamaGym());
                gymViewHolder.alamat_gym.setText(data.getAlamatGym());
                gymViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(gym.this, profil_gym.class);
                        i.putExtra("namagym", data.getNamaGym());
                        i.putExtra("alamatgym", data.getAlamatGym());
                        i.putExtra("img_gym",data.getImgUrl());

                        i.putExtra("pendaftaranMb",data.getBiaya_pendaftaran());
                        i.putExtra("biaya_satu",data.getBiaya_satuBulan());
                        i.putExtra("biaya_dua",data.getBiaya_duaBulan());
                        i.putExtra("biaya_tiga",data.getBiaya_tigaBulan());
                        i.putExtra("biaya_enam",data.getEnamBulan());
                        i.putExtra("insidentalMb",data.getBiaya_insindental());
                        i.putExtra("perpanjangan",data.getBiayaPerpanjangan());

                        i.putExtra("temu5",data.getBiaya_5Pertemuan());
                        i.putExtra("temu10",data.getBiaya_10Pertemuan());
                        i.putExtra("temu15",data.getBiaya_15Pertemuan());
                        i.putExtra("temu20",data.getBiaya_20Pertemuan());

                        i.putExtra("fasilitas_gym",data.getFasilitas());
                        i.putExtra("kelas_gym",data.getKelas());
                        i.putExtra("peralatan_gym",data.getPeralatan_kebugaran());
                        i.putExtra("keunggulan_gym",data.getKeunggulan_gym());
                        i.putExtra("gym_machine",data.getGymmachine());

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
