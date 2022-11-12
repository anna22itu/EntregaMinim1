package edu.upc.dsa.models;

public class DatosActivity {

    private int levelAct;
    private double puntosAct;
    private String fechaAct;

    public DatosActivity() {

    }

    public DatosActivity(int levelAct, double puntosAct, String fechaAct) {
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


