package edu.upc.dsa.models.Reg;

public class PartidaReg {

    private String idReg;
    private String descripcionReg;
    private int nivelesReg;

    public PartidaReg() {
    }

    public PartidaReg(String idReg, String descripcionReg, int nivelesReg) {
        this.idReg = idReg;
        this.descripcionReg = descripcionReg;
        this.nivelesReg = nivelesReg;
    }

    public String getIdReg() {
        return idReg;
    }

    public void setIdReg(String idReg) {
        this.idReg = idReg;
    }

    public String getDescripcionReg() {
        return descripcionReg;
    }

    public void setDescripcionReg(String descripcionReg) {
        this.descripcionReg = descripcionReg;
    }

    public int getNivelesReg() {
        return nivelesReg;
    }

    public void setNivelesReg(int nivelesReg) {
        this.nivelesReg = nivelesReg;
    }
}
