package edu.upc.dsa.models;

public class Credentials {

    private String idPartida;
    private String idUser;

    public Credentials() {
    }


    public Credentials(String idPartida, String idUser) {
        this.idPartida = idPartida;
        this.idUser = idUser;
    }

    public String getidPartida() {
        return idPartida;
    }

    public void setidPartida(String idPartida) {
        this.idPartida = idPartida;
    }

    public String getidUser() {
        return idUser;
    }

    public void setidUser(String idUser) {
        this.idUser = idUser;
    }

}
