package edu.upc.dsa;

import edu.upc.dsa.models.MyObject;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GestorJuegoImpl implements GestorJuego {
    private static GestorJuego instance;
    private List<MyObject> catalogo;
    private HashMap<String, User> users;
    final static Logger logger = Logger.getLogger(GestorJuegoImpl.class);

    public GestorJuegoImpl() {
        this.catalogo = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public static GestorJuego getInstance() {
        if (instance == null) instance = new GestorJuegoImpl();
        return instance;
    }

    public void registerUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password) {
        User u = new User(id, nombre, apellidos, nacimiento, correo, password);
        users.put(u.getId(), u);
        logger.info("new User added");
    }

    public List<User> ordenarUserAlfabet() {

        List<User> userList = new ArrayList<>(this.users.values());
        userList.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getNombre().compareTo(u2.getNombre());
            }
        });
        return userList;
    }

    public boolean logIn(String correo, String password) {

        boolean resultado = false;
        for (User u : this.users.values()) {
            String correoInput = u.getCorreo();
            String passwordInput = u.getPassword();
            if ((correoInput.equals(correo) && passwordInput.equals(password))) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public void addObject(MyObject o) {
        catalogo.add(o);
    }

    public List<MyObject> ordenarObjectByPrice() {
        this.catalogo.sort(new Comparator<MyObject>() {
            @Override
            public int compare(MyObject o2, MyObject o1) {
                return Double.compare(o1.getCoins(), o2.getCoins());
            }
        });
        return catalogo;
    }

    public boolean purchaseObject(String nameObject, String key) {
        User user = this.users.get(key);
        boolean bol = false;
        if (user != null) {
            user.setMisObjetos(this.getObject(nameObject));
            bol = true;
        }
        return bol;
    }

    public List<MyObject> listObjectByUser(String id) {
        User u = users.get(id);
        return u.getMisObjetos();
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    public int getNumUser() {
        int numUser = this.users.size();
        logger.info("size " + numUser);
        return numUser;
    }

    public int getNumObject() {
        int numObject = this.catalogo.size();
        logger.info("size " + numObject);
        return numObject;
    }

    public List<User> getUsers() {
        logger.info("users " + users);
        List<User> userList = new ArrayList<>(this.users.values());
        return userList;
    }

    public List<MyObject> getCatalogo() {
        logger.info("catalogo " + catalogo);
        return this.catalogo;
    }

    @Override
    public User getUser(String id) {
        User u = this.users.get(id);
        if (u.getId().equals(id)) {
            return users.get(id);
        }
        logger.info("getUser(" + id + "): " + u);
        return null;
    }

    @Override
    public MyObject getObject(String nombre) {
        for (MyObject o : catalogo) {
            if (o.getNombre().equals(nombre)) {
                return o;
            }
            logger.info("getObject(" + nombre + "): " + o);
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        User user = this.getUser(id);
        boolean bol = false;
        if (user == null) {
            logger.warn("not found " + user);
            bol = true;
        } else logger.info(user + " deleted ");
        this.users.remove(id);
        return bol;
    }

    /**
     @Override public void postUser(String id) {
     User user = this.getUser(id);
     if (user==null) {
     logger.warn("not found " + user);
     }
     else logger.info(user+" deleted ");
     this.users.remove(users);
     }*/

}