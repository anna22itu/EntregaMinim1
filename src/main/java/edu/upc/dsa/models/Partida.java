package edu.upc.dsa.models;

import java.util.HashMap;

public class Partida {
    private String id;
    private String descripcion;
    private int niveles;

    private HashMap<String,User> participantes;

    public Partida() {

    }

    public Partida(String nombre, String descripcion, int niveles) {
        this.id = nombre;
        this.descripcion = descripcion;
        this.niveles = niveles;
        this.participantes = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNiveles() {
        return niveles;
    }

    public void setNiveles(int niveles) {
        this.niveles = niveles;
    }

    public HashMap<String, User> getParticipantes() {
        return participantes;
    }

    public void removeParticipantes(User u) {
        this.participantes.remove(u.getId());
    }
    public void addParticipantes(User u) {
        this.participantes.put(u.getId(),u);
    }
}
