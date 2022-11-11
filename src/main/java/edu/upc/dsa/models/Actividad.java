package edu.upc.dsa.models;

public class Actividad {

    private String userId;
    private String idPartida;

    public Actividad() {
    }

    public Actividad(String userId, String idPartida) {
        this.userId = userId;
        this.idPartida = idPartida;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(String idPartida) {
        this.idPartida = idPartida;
    }
}
