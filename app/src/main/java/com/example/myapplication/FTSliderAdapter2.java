package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class FTSliderAdapter2 extends PagerAdapter {

    public int[] image_resource= {R.drawable.edu6,R.drawable.edu7,R.drawable.edu8,R.drawable.edu9revis,R.drawable.edu10};
    public String[] link ={"https://youtu.be/pJf2U4lzPLo","https://youtu.be/zV99now1GAI","https://youtu.be/jScVyFeV80E","https://youtu.be/0nixeAEiras","https://youtu.be/pAGxwki4XdA"};



    Context context;
    LayoutInflater layoutInflater;

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


    public FTSliderAdapter2(Context context){
        this.context = context;
    }

    public interface OnItemClickListener {
        void onChoiceClick(int position);
    }




    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }



    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_fakta_tips2,container,false);


        ImageView image_faktatips =(ImageView) view.findViewById(R.id.FaktaTips);
        image_faktatips.setAnimation(AnimationUtils.loadAnimation(context, R.anim.translate_y_show3));
        image_faktatips.setImageResource(image_resource[position]);


        final String s = link[position];
        container.addView(view);

        image_faktatips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(s));
                v.getContext().startActivity(intent);
            }
        });

        return view;
    }



    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
