package com.example.m1.myandroidlibrary;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeAndroidActivity extends AppCompatActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jokeandroidlayout);
        TextView textView=(TextView)findViewById(R.id.textView);
        Bundle bundle=getIntent().getExtras();
        String Joke=bundle.getString("joke");
        textView.setText(Joke);
    }
}
