package com.novillo.alquilopiso;

/**
 * Created by Jesus on 17/01/2017.
 */

public class Coordenadas {

    private int lat;
    private int lng;

    public Coordenadas(int lat, int lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLng() {
        return lng;
    }

    public void setLng(int lng) {
        this.lng = lng;
    }
}
