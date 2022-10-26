package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Object;

import java.util.*;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;

public class GestorJuegoImpl implements GestorJuego {
    private static GestorJuego instance;
    private List<Object> catalogo;
    private HashMap<String, User> users;
    final static Logger logger = Logger.getLogger(GestorJuegoImpl.class);

    public GestorJuegoImpl() {
        this.catalogo = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public static GestorJuego getInstance() {
        if (instance==null) instance = new GestorJuegoImpl();
        return instance;
    }

    public void registerUser(String id,String nombre, String apellidos, String nacimiento, String correo, String password){
        User u = new User(id, nombre, apellidos, nacimiento, correo,password);
        users.put(u.getId(),u);
        logger.info("new User added");
    }

    public List<User> ordenarUserAlfabet (){

        List<User> userList = new ArrayList<>(this.users.values());
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getNombre().compareTo(u2.getNombre());
            }
        });
        return userList;
    }

    public boolean logIn(String correo, String password){

        boolean resultado = false;
        for (User u:this.users.values()) {
            String correoInput = u.getCorreo();
            String passwordInput = u.getPassword();
            if ((correoInput.equals(correo) && passwordInput.equals(password))){
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public void addObject(Object o){
        catalogo.add(o);
    }

    public List<Object> ordenarObjectByPrice (){
        this.catalogo.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o2, Object o1) {
                return Double.compare(o1.getCoins(), o2.getCoins());
            }
        });
        return catalogo;
    }

    public void purchaseObject(Object o,String key){
        User user = this.users.get(key);
        if(user != null){
            user.setMisObjetos(o);
        }
    }

    public List<Object> listObjectByUser (String id){
        User u = users.get(id);
        return u.getMisObjetos();
    }

   ////////////////////////////////

    public int getNumUser(){
        int numUser = this.users.size();
        logger.info("size " + numUser);
        return numUser;
    }
    public int getNumObject(){
        int numObject = this.catalogo.size();
        logger.info("size " + numObject);
        return numObject;
    }
    public HashMap<String,User> getUsers(){
        return this.users;
    }
    public List<Object> getCatalogo(){
        return this.catalogo;
    }
    public User getUser(String id){
        User u = this.users.get(id);
        if (u.getId().equals(id)) {
            return users.get(id);
        }
        return null;
    }
    public Object getObject(String nombre){
        for (Object o : catalogo){
            if(o.getNombre().equals(nombre)){
                return o;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(String id) {

        User user = this.getUser(id);
        if (user==null) {
            logger.warn("not found " + user);
        }
        else logger.info(user+" deleted ");

        this.users.remove(users);
    }

/**
    public int size() {
        int ret = this.tracks.size();
        logger.info("size " + ret);

        return ret;
    }

    public User addUser(User t) {
        logger.info("new Track " + t);

        this.tracks.add (t);
        logger.info("new Track added");
        return t;
    }

    public User addUser(String title, String singer) {
        return this.addUser(new User(title, singer));
    }

    public User getUser(String id) {
        logger.info("getTrack("+id+")");

        for (User t: this.tracks) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<User> findAll() {
        return this.tracks;
    }

    @Override
    public void deleteUser(String id) {

        User t = this.getUser(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.tracks.remove(t);

    }

    @Override
    public User updateUser(User p) {
        User t = this.getUser(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setSinger(p.getSinger());
            t.setTitle(p.getTitle());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }*/
}