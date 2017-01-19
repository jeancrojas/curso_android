package com.jesus.aplicacion02login;

/**
 * Created by cice on 1/12/16.
 */

public class FlotaMotos implements Iterador {

    private Moto[] motos;

    public FlotaMotos(){

        motos = new Moto[3];
        getMotos();
    }

    public Moto[] getMotos(){
        motos[0] = new Moto("Ducati", 4);
        motos[1] = new Moto("Yamaha", 5);
        motos[2] = new Moto("Honda", 6);

        return motos;
    }


    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public FlotaMotos next() {
        return null;
    }
}
