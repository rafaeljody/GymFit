package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class GymViewHolder extends RecyclerView.ViewHolder {

    public TextView nama, alamat;
    public ImageView img;

    public GymViewHolder(@NonNull View view){
        super(view);
        nama= view.findViewById(R.id.tvNama);
        alamat = view.findViewById(R.id.tvAlamat);
        img = view.findViewById(R.id.imgGym);
    }
}
