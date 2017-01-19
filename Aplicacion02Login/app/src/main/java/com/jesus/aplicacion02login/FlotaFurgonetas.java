package com.jesus.aplicacion02login;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cice on 1/12/16.
 */

public class FlotaFurgonetas implements Iterador {

    private List<FlotaFurgonetas> furgonetas;

    public FlotaFurgonetas() {

        furgonetas = new ArrayList<>();
    }

    public List<FlotaFurgonetas> getFurgonetas() {

        FurgonetaPersonas fp1 = new FurgonetaPersonas("Mercedes",1);
        FurgonetaPersonas fp2 = new FurgonetaPersonas("Fiat",2);
        FurgonetaPersonas fp3 = new FurgonetaPersonas("Citroen", 3);

        return furgonetas;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public FlotaFurgonetas next() {
        return null;
    }
}
