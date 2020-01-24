package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class AdminActivity extends AppCompatActivity {

    Intent intent;
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
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
                    case R.id.tbdata:
                        tambahh();
                        break;
                    case R.id.eddata:
                        editt();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

    }

    public void login(){
        Intent intent = new Intent(AdminActivity.this, LoginActivity.class);
        startActivity(intent);
    }
    public void about(){
        Intent intent = new Intent(AdminActivity.this, AboutActivity.class);
        startActivity(intent);
    }
    public void help(){
        Intent intent = new Intent(AdminActivity.this, HelpActivity.class);
        startActivity(intent);
    }


    public void tambahh(){
        Intent intent = new Intent(AdminActivity.this, PilihTambahActivity.class);
        startActivity(intent);
    }

    public void editt(){
        Intent intent = new Intent(AdminActivity.this, PilihEditActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    public void tambah(View view){
        Intent intent = new Intent(AdminActivity.this, PilihTambahActivity.class);
        startActivity(intent);
    }

    public void edit(View view){
        Intent intent = new Intent(AdminActivity.this, PilihEditActivity.class);
        startActivity(intent);
    }



}
