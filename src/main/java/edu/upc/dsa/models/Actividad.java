package edu.upc.dsa.models;

public class Actividad {


    private String partidaId;
    private String UserId;

    public Actividad() {
    }

    public Actividad(String partidaId, String userId) {
        this.partidaId = partidaId;
        this.UserId = userId;
    }

    public String getPartidaIdAct() {
        return partidaId;
    }

    public void setPartidaIdAct(String partidaId) {
        this.partidaId = partidaId;
    }

    public String getUserIdAct() {
        return UserId;
    }

    public void setUserIdAct(String userId) {
        UserId = userId;
    }
}
