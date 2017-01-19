package com.jesus.aplicacion02login;

import java.util.Iterator;

/**
 * Created by cice on 1/12/16.
 */

public class IteradorMotos implements Iterador <Vehiculo> {

    private int pos = 0;
    private Moto[] motos;

    public IteradorMotos(Moto[] motos){
        super();
        this.motos = motos;
    }



    @Override
    public boolean hasNext() {
        return pos+1 <= motos.length && motos[pos] != null;
    }

    @Override
    public Vehiculo next() {

        Moto moto = motos[pos];
        pos++;
        return moto;
    }
}
