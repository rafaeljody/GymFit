package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class trainer extends AppCompatActivity {
    private RecyclerView mTrainerList;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        mDatabase= FirebaseDatabase.getInstance().getReference().child("DATA TRAINER");
        mDatabase.keepSynced(true);

        mTrainerList=(RecyclerView)findViewById(R.id.rv_main);
        mTrainerList.setHasFixedSize(true);
        mTrainerList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<personalTrainer, trainer.TrainerViewHolder> firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<personalTrainer, trainer.TrainerViewHolder>
                (personalTrainer.class,R.layout.daftar_trainer, trainer.TrainerViewHolder.class,mDatabase) {
            @Override
            protected void populateViewHolder(trainer.TrainerViewHolder trainerViewHolder, personalTrainer pt, int i) {
                trainerViewHolder.setTrainer(pt.getNama_trainer());
                trainerViewHolder.setSpesialisasi(pt.getKeahlian());
                trainerViewHolder.setImage(getApplicationContext(),pt.getImgUrl());
            }
        };

        mTrainerList.setAdapter(firebaseRecyclerAdapter);
    }

    public static class TrainerViewHolder extends RecyclerView.ViewHolder
    {
        View mView;
        public TrainerViewHolder(View itemView)
        {
            super(itemView);
            mView=itemView;
        }
        public void setTrainer(String title){
            TextView postTrainer=(TextView)mView.findViewById(R.id.tvNama);
            postTrainer.setText(title);
        }
        public void setSpesialisasi(String spe){
            TextView postKeahlian=(TextView)mView.findViewById(R.id.tvSpesialisasi);
            postKeahlian.setText(spe);
        }
        public void setImage(Context ctx, String image){
            ImageView postImage=(ImageView)mView.findViewById(R.id.imgTrainer);
            Picasso.get().load(image).into(postImage);
        }
    }
}
