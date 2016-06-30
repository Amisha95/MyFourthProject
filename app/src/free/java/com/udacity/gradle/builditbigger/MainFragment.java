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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainFragment extends Fragment {

    Jokes joke;
    InterstitialAd interstitialAd;
    View rootView;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        Button button = (Button)rootView.findViewById(R.id.button);
        interstitialAd = new InterstitialAd(getActivity().getApplicationContext());
        interstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        requestAdd();
        joke = new Jokes();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                    Intent intent=new Intent(getActivity().getApplicationContext(), JokeAndroidActivity.class);
                    intent.putExtra("joke",joke.getJoke());
                    new EndpointsAsyncTask().execute(getActivity().getApplicationContext());
                    startActivity(intent);
                } else {
                    Intent intent=new Intent(getActivity().getApplicationContext(), JokeAndroidActivity.class);
                    intent.putExtra("joke",joke.getJoke());
                    new EndpointsAsyncTask().execute(getActivity().getApplicationContext());
                    startActivity(intent);
                }
            }
        });

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestAdd();
            }
        });

        return rootView;
    }

    private void requestAdd() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        interstitialAd.loadAd(adRequest);
    }
}
