package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.MyObject;

import java.util.List;


import java.util.HashMap;

public interface GestorJuego {
    /**
     * Definimos los métodos principales que nos pide el ejercicio
     */
    public void registerUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password);
    public List<User> ordenarUserAlfabet ();
    public boolean logIn(String correo, String password);
    public void addObject(MyObject o);
    public List<MyObject> ordenarObjectByPrice ();
    public boolean purchaseObject(String nameObject, String id);
    public List<MyObject> listObjectByUser (String id);


    public int getNumUser();
    public int getNumObject();
    public List<User> getUsers();
    public List<MyObject> getCatalogo();
    public User getUser(String id);
    public MyObject getObject(String id);
    public boolean deleteUser(String id);

}