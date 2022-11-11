package edu.upc.dsa.models;

public class DatosActividad {

    private int levelAct;
    private double puntosAct;
    private String fechaAct;

    public DatosActividad() {

    }

    public DatosActividad(int levelAct, double puntosAct, String fechaAct) {
        this.levelAct = levelAct;
        this.puntosAct = puntosAct;
        this.fechaAct = fechaAct;
    }

    public int getLevelAct() {
        return levelAct;
    }

    public void setLevelAct(int levelAct) {
        this.levelAct = levelAct;
    }

    public double getPuntosAct() {
        return puntosAct;
    }

    public void setPuntosAct(double puntosAct) {
        this.puntosAct = puntosAct;
    }

    public String getFechaAct() {
        return fechaAct;
    }

    public void setFechaAct(String fechaAct) {
        this.fechaAct = fechaAct;
    }
}


