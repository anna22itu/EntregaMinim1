package edu.upc.dsa.models;

public class UserReg {

    private String nombreReg;
    private String apellidosReg;
    private String nacimientoReg;
    private String correoReg;
    private String passwordReg;
    private String idReg;


    public UserReg(){

    }

    public UserReg(String nombre, String apellidos, String nacimiento, String correo, String password, String id) {
        this.nombreReg = nombre;
        this.apellidosReg = apellidos;
        this.nacimientoReg = nacimiento;
        this.correoReg = correo;
        this.passwordReg = password;
        this.idReg = id;
    }

    public String getNombreReg() {
        return nombreReg;
    }

    public void setNombreReg(String nombreReg) {
        this.nombreReg = nombreReg;
    }

    public String getApellidosReg() {
        return apellidosReg;
    }

    public void setApellidosReg(String apellidosReg) {
        this.apellidosReg = apellidosReg;
    }

    public String getNacimientoReg() {
        return nacimientoReg;
    }

    public void setNacimientoReg(String nacimientoReg) {
        this.nacimientoReg = nacimientoReg;
    }

    public String getCorreoReg() {
        return correoReg;
    }

    public void setCorreoReg(String correoReg) {
        this.correoReg = correoReg;
    }

    public String getPasswordReg() {
        return passwordReg;
    }

    public void setPasswordReg(String passwordReg) {
        this.passwordReg = passwordReg;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }
}
