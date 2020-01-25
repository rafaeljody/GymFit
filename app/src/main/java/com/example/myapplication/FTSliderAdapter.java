package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;


public class FTSliderAdapter extends PagerAdapter {

    private int[] image_resource= {R.drawable.edu1,R.drawable.edu2,R.drawable.edu3,R.drawable.edu4,R.drawable.edu5};
    Context context;
    LayoutInflater layoutInflater;

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }


    public FTSliderAdapter(Context context){
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
        View view = layoutInflater.inflate(R.layout.slide_fakta_tips,container,false);


        ImageView image_faktatips =(ImageView) view.findViewById(R.id.text_FaktaTips);
        image_faktatips.setAnimation(AnimationUtils.loadAnimation(context, R.anim.translate_y_show3));
        image_faktatips.setImageResource(image_resource[position]);
        /*int total = getCount();
        text_count.setText(position+1+" / "+total);
*/
        container.addView(view);

        return view;
    }



    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
