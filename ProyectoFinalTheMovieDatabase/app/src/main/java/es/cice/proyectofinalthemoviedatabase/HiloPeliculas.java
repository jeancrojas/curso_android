package es.cice.proyectofinalthemoviedatabase;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import es.cice.proyectofinalthemoviedatabase.model.Pelicula;

import static android.content.ContentValues.TAG;

/**
 * Created by cice on 15/2/17.
 */

public class HiloPeliculas extends Thread {

    List<Pelicula> pelicula;

    public List<Pelicula> getPelicula() {
        return pelicula;
    }

    URL url;

    public HiloPeliculas(String enlace){
        pelicula = new ArrayList<>();

        try {
            url = new URL(enlace);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public Pelicula obtenerPelicula(int index){
        return pelicula.get(index);
    }

    @Override
    public void run() {
        super.run();
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer data = new StringBuffer();
            String line = "";

            while ((line = bufferedReader.readLine()) != null ){
                data.append(line);
            }
            /*Gson gson= new Gson();
            gson.fromJson(bufferedReader, modelo.class)*/

            JSONObject jsonObject = new JSONObject(data.toString());
            JSONArray results = jsonObject.getJSONArray("results");

            for (int i=0; i < results.length();i++) {
                JSONObject jsonMovie = results.getJSONObject(i);
                int id = Integer.parseInt( jsonMovie.getString("id") );
                String original_title = jsonMovie.getString("original_title");


                String urlImage = Pelicula.BASE_URL_IMAGE+jsonMovie.getString("poster_path");
                URL url = new URL(urlImage);
                Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                String backdrop_path = Pelicula.BASE_URL_IMAGE+jsonMovie.getString("backdrop_path");

                String release_date = jsonMovie.getString("release_date");
                double vote_average = Double.parseDouble(jsonMovie.getString("vote_average"));

                String overview = jsonMovie.getString("overview");

                pelicula.add(new Pelicula(id, Bitmap.createScaledBitmap(image,180,270, false), urlImage, backdrop_path, release_date,original_title,vote_average, overview));
            }

            /*

            for (Pelicula p : pelicula) {
                Log.d(TAG, "slowWorkerThread... "+p.toString());
            }
            */




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
