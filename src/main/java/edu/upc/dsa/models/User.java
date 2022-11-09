package edu.upc.dsa.models;

import java.util.LinkedList;

public class User {

    private String nombre;
    private String apellidos;
    private String nacimiento;
    private String correo;
    private String password;
    private String id;
    private double saldo;
    private LinkedList<MyObject> misObjetos;

    public User() {

    }

    public User(String id, String nombre, String apellidos, String nacimiento, String correo, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacimiento = nacimiento;
        this.correo = correo;
        this.password = password;
        this.id = id;
        this.saldo = 50;
        this.misObjetos = new LinkedList<>();
    }

    public LinkedList<MyObject> getMisObjetos() {
        return misObjetos;
    }

    public int getNumberMisObjetos() {
        return misObjetos.size();
    }

    public void setMisObjetos(MyObject miObjeto) {
        this.misObjetos.add(miObjeto);
        this.saldo = this.getSaldo() - miObjeto.getCoins();
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


}