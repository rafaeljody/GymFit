package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class TrainerViewHolder extends RecyclerView.ViewHolder {

    public TextView nama,splesialisasi;
    public ImageView img;
  //  private Context context2;

   Button btEdit;

    public TrainerViewHolder(@NonNull View view){
        super(view);
     //   context2 = view.getContext();
        nama=view.findViewById(R.id.tvNama);
        splesialisasi=view.findViewById(R.id.tvSpesialisasi);
        img=view.findViewById(R.id.imgTrainer);
        //btEdit=view.findViewById(R.id.btn_edit);





    }
}
