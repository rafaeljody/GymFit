package com.example.myapplication;

import android.content.Context;
import android.media.Image;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class PicassoGym {

    public static void downloadImage(Context ctx, String uri, ImageView imgv){
        if(uri!=null && uri.length()>0){
            Picasso.get().load(uri).placeholder(R.drawable.placeholder).into(imgv);
        }
        else{
            Picasso.get().load(R.drawable.placeholder).into(imgv);
        }
    }
}
