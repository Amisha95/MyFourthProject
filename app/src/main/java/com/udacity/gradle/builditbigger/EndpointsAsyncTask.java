package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.m1.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected String doInBackground(Void...params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

      //  context=params[0];
        String Joke=null;

        try {
            Joke=myApiService.sayHi("Amisha").execute().getData();
          //  Joke=myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
        return Joke;
    }

    @Override
    protected void onPostExecute(String result) {
     /*   super.onPostExecute(result);
        Intent intent=new Intent(context, JokeAndroidActivity.class);
        intent.putExtra("joke",result);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent); */
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}
