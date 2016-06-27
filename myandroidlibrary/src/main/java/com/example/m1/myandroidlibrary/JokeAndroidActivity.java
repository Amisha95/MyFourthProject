package com.example.m1.myandroidlibrary;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class JokeAndroidActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        Bundle bundle=getIntent().getExtras();
        String Joke=bundle.getString("joke");
        Toast.makeText(this, Joke, Toast.LENGTH_SHORT).show();
    }
}
