package com.jesus.aplicacion02login;

import java.util.Iterator;
import java.util.List;

/**
 * Created by cice on 1/12/16.
 */

public class IteradorFurgonetas implements Iterador<Vehiculo> {

    private int pos = 0;

    private List<FurgonetaPersonas> furgonetas;

    public IteradorFurgonetas(List<FurgonetaPersonas> furgonetas) {
        super();
        this.furgonetas = furgonetas;
    }

    @Override
    public boolean hasNext() {
        return pos + 1 <= furgonetas.size();
    }

    @Override
    public Vehiculo next() {
        FurgonetaPersonas furgoneta = furgonetas.get(pos);
        return furgoneta;
    }
}
