package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class TipsActivity extends AppCompatActivity {

    private ViewPager mFaktaTipsPager;
    public FTSliderAdapter ftSliderAdapter;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        hideStatusBar();

        mFaktaTipsPager = findViewById(R.id.slideFaktaTips);
        title = findViewById(R.id.title_fakta);
        title.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_right_show));

        ftSliderAdapter = new FTSliderAdapter(this);
        mFaktaTipsPager.setAdapter(ftSliderAdapter);


        /*TextView counter = findViewById(R.id.counter);
        counter.setText("1 / "+ftSliderAdapter.getCount());

        mFaktaTipsPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int a = ftSliderAdapter.getCount();
                TextView counter = findViewById(R.id.counter);

                for (int i  = 1; i< a; i++){
                    counter.setText(position + 1+ " / " +a);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        }); */


    }

    /*private void setCounter(){
        int a = mFaktaTipsPager.getCurrentItem();
        TextView counter = findViewById(R.id.counter);
        counter.setText(a);
    }*/

    public void hideStatusBar(){
        Window window = getWindow();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }

}
