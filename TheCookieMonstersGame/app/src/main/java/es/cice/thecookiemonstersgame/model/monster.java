package es.cice.thecookiemonstersgame.model;

/**
 * Created by cice on 31/1/17.
 */

public class monster {

    String nombre;
    int numGalletas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumGalletas() {
        return numGalletas;
    }

    public void setNumGalletas(int numGalletas) {
        this.numGalletas = numGalletas;
    }

    public monster(String nombre, int numGalletas) {
        this.nombre = nombre;
        this.numGalletas = numGalletas;
    }
}
