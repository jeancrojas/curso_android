package com.novillo.a07bases_de_datos;

/**
 * Created by cice on 15/12/16.
 */

public class Vehiculo {

    private String tipo;
    private String modelo;
    private String matricula;
    private int foto;

    public Vehiculo(String tipo, String matricula, String modelo, int foto) {
        this.tipo = tipo;
        this.matricula = matricula;
        this.modelo = modelo;
        this.foto = foto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
