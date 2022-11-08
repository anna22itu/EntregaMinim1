package edu.upc.dsa.models;

public class MyObject {
    private String nombre;
    private String descripcion;
    private double coins;

    public MyObject() {

    }

    public MyObject(String nombre, String descripcion, double coins) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.coins = coins;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getCoins() {
        return coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
    }
}
