package com.novillo.alquilopiso;

/**
 * Created by Jesus on 14/01/2017.
 */

public class Piso {
    private String direccion;
    private double lat;
    private double lng;
    private String metros;
    private String habitaciones;
    private String baños;
    private String precio;
    private String telefono;
    private String foto1;
    private String foto2;
    private String foto3;
    private String foto4;
    private String foto5;

    public Piso(String direccion, double lat, double lng, String metros, String habitaciones, String baños, String precio,
                String telefono, String foto1, String foto2, String foto3, String foto4, String foto5) {
        this.direccion = direccion;
        this.lat = lat;
        this.lng = lng;
        this.metros = metros;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.precio = precio;
        this.telefono = telefono;
        this.foto1 = foto1;
        this.foto2 = foto2;
        this.foto3 = foto3;
        this.foto4 = foto4;
        this.foto5 = foto5;
    }

    ////////// SOBRECARGADO PARA PROBAR SIN FOTOS//////////
    public Piso(String direccion, double lat, double lng, String metros, String habitaciones, String baños, String precio,
                String telefono) {
        this.direccion = direccion;
        this.lat = lat;
        this.lng = lng;
        this.metros = metros;
        this.habitaciones = habitaciones;
        this.baños = baños;
        this.precio = precio;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getMetros() {
        return metros;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public String getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(String habitaciones) {
        this.habitaciones = habitaciones;
    }

    public String getBaños() {
        return baños;
    }

    public void setBaños(String baños) {
        this.baños = baños;
    }

    public String getPrecio() { return precio; }

    public void setPrecio(String precio) { this.precio = precio; }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFoto1() {
        return foto1;
    }

    public void setFoto1(String foto1) {
        this.foto1 = foto1;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public String getFoto4() {
        return foto4;
    }

    public void setFoto4(String foto4) { this.foto4 = foto4; }

    public String getFoto5() {
        return foto5;
    }

    public void setFoto5(String foto5) {
        this.foto5 = foto5;
    }
}
