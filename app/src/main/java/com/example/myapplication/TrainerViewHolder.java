package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class TrainerViewHolder extends RecyclerView.ViewHolder {

    public TextView nama,splesialisasi;
    public ImageView img;

    public TrainerViewHolder(@NonNull View view){
        super(view);
        nama=view.findViewById(R.id.tvNama);
        splesialisasi=view.findViewById(R.id.tvSpesialisasi);
        img=view.findViewById(R.id.imgTrainer);

//        public void setDetails(Context ctx, String namaa, String spesial, String image){
//            //Views
//            nama=mView.findViewById(R.id.tvNama);
//            splesialisasi=mView.findViewById(R.id.tvSpesialisasi);
//            img=mView.findViewById(R.id.imgTrainer);
//            //set data to views
//            nama.setText(namaa);
//            splesialisasi.setText(spesial);
//            Picasso.get().load(image).into(img);
//        }
    }
}
