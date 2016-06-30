package com.udacity.gradle.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.Jokes;
import com.example.m1.myandroidlibrary.JokeAndroidActivity;

public class MainFragment extends Fragment {

    Jokes joke;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button)rootView.findViewById(R.id.button);
        joke = new Jokes();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity().getApplicationContext(), JokeAndroidActivity.class);
                intent.putExtra("joke",joke.getJoke());
                new EndpointsAsyncTask().execute(getActivity().getApplicationContext());
                startActivity(intent);
            }
        });
        return rootView;
    }
}
