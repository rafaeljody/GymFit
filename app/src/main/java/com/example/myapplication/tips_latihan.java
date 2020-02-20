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


public class tips_latihan extends AppCompatActivity {


    private ViewPager mFaktaTipsPager;
    public FTSliderAdapter2 ftSliderAdapter;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_latihan);

        hideStatusBar();

        mFaktaTipsPager = findViewById(R.id.slideFaktaTips);
        title = findViewById(R.id.title_fakta);
        title.setAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_right_show));

        ftSliderAdapter = new FTSliderAdapter2(this);
        mFaktaTipsPager.setAdapter(ftSliderAdapter);
    }

    public void hideStatusBar(){
        Window window = getWindow();

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.AUTOFILL_FLAG_INCLUDE_NOT_IMPORTANT_VIEWS);

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.TRANSPARENT);
    }
}
