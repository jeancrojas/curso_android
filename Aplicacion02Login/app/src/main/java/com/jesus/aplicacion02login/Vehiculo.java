package com.jesus.aplicacion02login;

/**
 * Created by cice on 30/11/16.
 */

public class Vehiculo {
    int     idVehiculo;
    String  modelo;
    Double  precioAlquilerDia;



    public Vehiculo(String modelo, int idVehiculo) {
        this.modelo = modelo;
        this.idVehiculo = idVehiculo;
    }

    public Double calcularAlquiler(int dias){
        Double total;
        total=precioAlquilerDia*dias;
        return total;
    }


    public Double getPrecioAlquilerDia() {
        return precioAlquilerDia;
    }

    public void setPrecioAlquilerDia(Double precioAlquilerDia) {
        precioAlquilerDia = precioAlquilerDia;
    }

    public String getModelo() {
        return modelo;
    }

    public FurgonetaPersonas setModelo(String modelo) {
        this.modelo = modelo;
        return null;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
}
