package es.cice.proyectofinalthemoviedatabase.model;

import android.graphics.Bitmap;

/**
 * Created by cice on 13/2/17.
 */

public class Pelicula {
    public static final String BASE_URL_IMAGE = "https://image.tmdb.org/t/p/w500";
    int id;
    String original_title;
    Bitmap image;
    String release_date;
    double vote_average;

    public Pelicula(int id, Bitmap image, String release_date, String original_title, double vote_average) {
        this.id = id;
        this.image = image;
        this.release_date = release_date;
        this.original_title = original_title;
        this.vote_average = vote_average;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return original_title;
    }

    public void setTitle(String title) {
        this.original_title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public String toString() {
        return "Pelicula:" +
                "\nid=" + id +
                "\nTítulo='" + original_title +
                "\nImagen=" + image +
                "\nFecha de Lanzamiento='" + release_date +
                "\nVotación=" + vote_average;
    }
}
