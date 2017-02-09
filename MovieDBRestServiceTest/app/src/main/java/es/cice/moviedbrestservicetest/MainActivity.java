package es.cice.moviedbrestservicetest;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://api.themoviedb.org/3";
    private static final String API_KEY = "e4190e0e5981362e0722c17cfd44da57";
    private static final String TAG = "MainActivity";
    //static TextView moviesTV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void getMovies (View v){
        TheMovieDBAsyncTask at = new TheMovieDBAsyncTask();
        at.execute("https://api.themoviedb.org/3/movie/popular?api_key=e4190e0e5981362e0722c17cfd44da57");
    }

    public void listTest(View view) {



        Intent intent = new Intent(this, listMovieTest.class );
        startActivity(intent);
    }

    public class TheMovieDBAsyncTask extends AsyncTask<String, Void, Void> {


        @Override
        protected void onPostExecute(List<String> movieList) {
            TextView moviesTV = (TextView) findViewById(R.id.movies);
            for (String movie : movieList){
                moviesTV.setText(movie);
            }

        }

        @Override
        protected List<String> doInBackground(String... urls) {
            BufferedReader in = null
            List<String> movieList = new ArrayList<>();
            //

            URL url = null;
            try {
                url = new URL(urls[0]);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();

                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                StringBuffer data = new StringBuffer();
                //Insertar los datos obtenidos con el flujo en el StringBuffer


                String line = null;

                while ( (line = in.readLine()) != null ) {
                    data.append(line);
                }



                JSONObject jsonObject = new JSONObject(data.toString());
                JSONArray results = jsonObject.getJSONArray("results");
                for (int i=0; i < results.length(); i++) {
                    JSONObject jsonMovie = results.getJSONObject(i);
                    String title = jsonMovie.getString("original_title");
                    String release_date = jsonMovie.getString("release_date");
                    Log.d(TAG, "Titulo: "+title+"\nEstreno: "+release_date+"\n\n");
                    movieList.add(title);
                }

                return movieList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }


            return null;


        }
    }
}
