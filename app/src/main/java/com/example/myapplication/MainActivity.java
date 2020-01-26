package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(" ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        dl = (DrawerLayout)findViewById(R.id.activity_main);
        t = new ActionBarDrawerToggle(this, dl,R.string.Open, R.string.Close);

        dl.addDrawerListener(t);
        t.syncState();


        nv = (NavigationView)findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Activity selectedActivity = null;
                switch(id)
                {
                    case R.id.login:
                    login();
                    break;
                    case R.id.about:
                        about();
                        break;
                    case R.id.help:
                        help();
                        break;
                    case R.id.tips1:
                        tipss();
                        break;
                    case R.id.gym1:
                        gymm();
                        break;
                    case R.id.trainer1:
                        trainerr();
                        break;
                    case R.id.cp1:
                        cpp();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

    }

    public void login(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    public void about(){
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
    public void help(){
        Intent intent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(intent);
    }

    public void tipss(){
        Intent intent = new Intent(MainActivity.this, MasukEduActivity.class);
        startActivity(intent);
    }
    public void gymm(){
        Intent intent = new Intent(MainActivity.this, gym.class);
        startActivity(intent);
    }
    public void trainerr(){
        Intent intent = new Intent(MainActivity.this, trainer.class);
        startActivity(intent);
    }

    public void cpp(){
        try {
            String text = "Terimakasih telah menggunakan GYM FIT, silakan bertanya:././";// Replace with your message.

            String toNumber = "6285643377456"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void gym(View view){
        Intent intent = new Intent(MainActivity.this, gym.class);
        startActivity(intent);
    }

    public void trainer(View view){
        Intent intent = new Intent(MainActivity.this, trainer.class);
        startActivity(intent);
    }

    public void tips(View view){
        Intent intent = new Intent(MainActivity.this, MasukEduActivity.class);
        startActivity(intent);
    }

    public void cp(View view){
        try {
            String text = "Terimakasih telah menggunakan GYM FIT, silakan bertanya: \n\n";// Replace with your message.

            String toNumber = "6285643377456"; // Replace with mobile phone number without +Sign or leading zeros, but with country code
            //Suppose your country is India and your phone number is “xxxxxxxxxx”, then you need to send “91xxxxxxxxxx”.


            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="+text));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
