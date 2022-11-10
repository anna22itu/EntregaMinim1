package edu.upc.dsa.models;

public class Actividad {

    private String userId;
    private String juego;

    public Actividad() {
    }

    public Actividad(String userId, String descripcion) {
        this.userId = userId;
        this.juego = descripcion;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }
}
