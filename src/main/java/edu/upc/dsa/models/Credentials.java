package edu.upc.dsa.models;

public class Credentials {

    private String correoLI;
    private String passwordLI;

    public Credentials() {
    }

    public Credentials(String correoLI, String passwordLI) {
        this.correoLI = correoLI;
        this.passwordLI = passwordLI;
    }

    public String getCorreoLI() {
        return correoLI;
    }

    public void setCorreoLI(String correoLI) {
        this.correoLI = correoLI;
    }

    public String getPasswordLI() {
        return passwordLI;
    }

    public void setPasswordLI(String passwordLI) {
        this.passwordLI = passwordLI;
    }

    /**
    public Boolean isEqual(UserLogIn userLogIn) {
        return (this.correoLI.equals(userLogIn.getCorreoLI()) && this.passwordLI.equals(userLogIn.getPasswordLI()));
    }*/
}
