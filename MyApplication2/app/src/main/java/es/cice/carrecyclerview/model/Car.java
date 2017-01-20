package es.cice.carrecyclerview.model;

/**
 * Created by cice on 19/1/17.
 */

public class Car {

    private String modelo;
    private String fabricante;
    private String descripcion;
    private int miniatura;
    private int image;

    public Car(String descripcion, String fabricante, int image, int miniatura, String modelo) {
        this.descripcion = descripcion;
        this.fabricante = fabricante;
        this.image = image;
        this.miniatura = miniatura;
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getMiniatura() {
        return miniatura;
    }

    public void setMiniatura(int miniatura) {
        this.miniatura = miniatura;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
