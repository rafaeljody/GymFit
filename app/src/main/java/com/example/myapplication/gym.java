package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class gym extends AppCompatActivity {


    private RecyclerView mGymList;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("Detail-GYM");
        mDatabase.keepSynced(true);

        mGymList=(RecyclerView)findViewById(R.id.rv_main);
        mGymList.setHasFixedSize(true);
        mGymList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Data,DataViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<Data, DataViewHolder>
                (Data.class,R.layout.daftar_gym,DataViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(DataViewHolder dataViewHolder, Data data, int i) {
                dataViewHolder.setTitle(data.getNamaGym());
                dataViewHolder.setAlamat(data.getAlamatGym());
            }
        };

        mGymList.setAdapter(firebaseRecyclerAdapter);

    }

    public static class DataViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public DataViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTitle(String title){
            TextView postTitle=(TextView)mView.findViewById(R.id.tvNama);
            postTitle.setText(title);
        }
        public void setAlamat(String ala){
            TextView postAlamat=(TextView)mView.findViewById(R.id.tvAlamat);
            postAlamat.setText(ala);
        }
    }


}
