package edu.upc.dsa.models;

import edu.upc.dsa.models.Data.DatosActivity;
import edu.upc.dsa.models.EO.*;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String correo;
    private String password;
    private String id;
    private double puntos;
    private Partida myCurrentPartida;

    private List<Partida> misPartidas;
    private int myCurrentNivel;
    private List<Level> misNiveles;

    private List<DatosActivity> datosMisActividades;

    public User() {

    }


    public User(String id, String nombre, String apellidos, String nacimiento, String correo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.password = password;
        this.id = id;
        this.puntos = 0;
        this.myCurrentPartida = new Partida();
        this.myCurrentNivel = 0;
        this.misPartidas= new ArrayList<>();
        this.misNiveles= new ArrayList<>();
        this.datosMisActividades= new ArrayList<>();
    }

    public Partida getMyCurrentPartida() {
        return myCurrentPartida;
    }


    public void setMyCurrentPartida(Partida partida) {
        this.myCurrentPartida = partida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPuntos() {
        return puntos;
    }

    public void setPuntos(double puntos) {
        this.puntos = puntos;
    }

    public int getcurrentNivel() {
        return myCurrentNivel;
    }

    public void setMyCurrentNivel(int myCurrentNivel) {
        this.myCurrentNivel = myCurrentNivel;
    }

    public List<Partida> getMisPartidas() {
        return misPartidas;
    }

    public void setMisPartidas() {
        this.misPartidas.add(this.getMyCurrentPartida());
    }


    public List<Level> getMisNiveles() {
        return misNiveles;
    }

    public void addMisNiveles(int l) {
        Level level = new Level(l);
        misNiveles.add(level);
    }

    public void setMisNiveles(List<Level> misNiveles) {
        this.misNiveles = misNiveles;
    }

    public List<DatosActivity> getDatosMisActividades() {
        return datosMisActividades;
    }

    public void setDatosMisActividades(DatosActivity miActividad) {
        datosMisActividades.add(miActividad);
    }

}