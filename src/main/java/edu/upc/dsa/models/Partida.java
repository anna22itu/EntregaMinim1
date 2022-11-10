package edu.upc.dsa.models;

import java.util.HashMap;

public class Partida {
    private String id;
    private String descripcion;
    private int nivel;

    private HashMap<String,User> participantes;

    public Partida() {

    }

    public Partida(String nombre, String descripcion, int nivel) {
        this.id = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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
