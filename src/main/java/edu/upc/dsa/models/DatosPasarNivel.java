package edu.upc.dsa.models;

public class DatosPasarNivel {

    private String idUser;
    private double puntos;
    private String fecha;

    public DatosPasarNivel() {

    }

    public DatosPasarNivel(String idUser, double puntos, String fecha) {
        this.idUser = idUser;
        this.puntos = puntos;
        this.fecha = fecha;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
