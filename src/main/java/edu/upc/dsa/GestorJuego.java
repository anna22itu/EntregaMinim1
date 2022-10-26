package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Object;

import java.util.List;


import java.util.HashMap;
import java.util.List;

public interface GestorJuego {
    /**
     * Definimos los métodos principales que nos pide el ejercicio
     */
    public void registerUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password);
    public List<User> ordenarUserAlfabet ();
    public boolean logIn(String correo, String password);
    public void addObject(Object o);
    public List<Object> ordenarObjectByPrice ();
    public void purchaseObject(Object o,String u);
    public List<Object> listObjectByUser (String id);


    public int getNumUser();
    public int getNumObject();
    public HashMap<String,User> getUsers();
    public List<Object> getCatalogo();
    public User getUser(String id);
    public Object getObject(String id);
    public void deleteUser(String id);

}