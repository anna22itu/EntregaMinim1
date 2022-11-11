package edu.upc.dsa;

import edu.upc.dsa.models.Actividad;
import edu.upc.dsa.models.DatosActividad;
import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;

import java.util.List;

public interface GestorJuego {
    /**
     * Definimos los métodos principales que nos pide el ejercicio
     */

    public void crearPartida (String id, String descripcion, int niveles);

    public void iniciarPartida (String id, String idUser);

    public void registerUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password);

    public int nivelUser(String idUser);

    public double puntosDeUser(String idUser);

    public void pasarNivel(String idUser, double puntos, String fecha);

    public boolean finalizarPartida(String idUser);

    public List<Partida> getMyPartidas(String idUser);

    public List<User> getUsersOfPartida(String idPartida);

    //public List<DatosActividad> actividad(String idUser, String idPartida);



    ////////////////////////////////////////////////////////////////////


    public void updateUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password);

    public int getNumUser();

    public int getNumPartidas();

    public List<User> getUsers();

    public List<Partida> getPartidas();

    public User getUser(String id);

    public boolean deleteUser(String id);


}