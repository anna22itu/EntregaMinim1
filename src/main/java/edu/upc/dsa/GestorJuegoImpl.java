package edu.upc.dsa;

import edu.upc.dsa.models.Partida;
import edu.upc.dsa.models.User;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class GestorJuegoImpl implements GestorJuego {
    private static GestorJuego instance;
    private List<Partida> partidas;
    private HashMap<String, User> users;
    final static Logger logger = Logger.getLogger(GestorJuegoImpl.class);

    public GestorJuegoImpl() {
        this.partidas = new ArrayList<>();
        this.users = new HashMap<>();
    }

    public static GestorJuego getInstance() {
        if (instance == null) instance = new GestorJuegoImpl();
        return instance;
    }

    public void crearPartida (String id, String descripcion, int niveles){
        Partida p = new Partida(id,descripcion,niveles);
        this.partidas.add(p);
    }


    public void iniciarPartida (String idPartida, String idUser){

        User u = this.users.get(idUser);

        u.setPuntos(50);

        Partida partida = null;
        for (Partida p : partidas) {
            if (p.getId().equals(idPartida))
            {
                partida = p;
            }
        }
        u.setMyCurrentPartida(partida);
        u.setMisPartidas();
        partida.addParticipantes(u);
    }

    public void registerUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password) {
        User u = new User(id, nombre, apellidos, nacimiento, correo, password);
        users.put(u.getId(), u);
        logger.info("new User added");
    }


    public int nivelUser(String idUser){
        User u = this.users.get(idUser);
        return u.getcurrentNivel();
    }

    public double puntosDeUser(String idUser){
        User u = this.users.get(idUser);
        return u.getPuntos();
    }

    public void pasarNivel(String idUser, double puntos, String fecha){
        User u = this.users.get(idUser);

        if(u.getcurrentNivel()  == u.getMyCurrentPartida().getNiveles()){ // primero comprobamos que no esté en el último nivel
            u.setPuntos(u.getPuntos() + 100);
            this.finalizarPartida(u.getId());
        }
        u.setNivel(u.getcurrentNivel() + 1); // si no lo está lo cambiamos de nivel
        u.setPuntos(u.getPuntos() + puntos);
    }


    public boolean finalizarPartida(String idUser){
        User u = this.users.get(idUser);
        u.getMyCurrentPartida().removeParticipantes(u); // cuando acaba la partida lo eliminamos de la lista de los jugadores de esa partida
        u.setMyCurrentPartida(null); // la partida la pondremos a null pq ya ha finalizado la partida
        return  true;
    }

    public List<User> getUsersOfPartida(String idPartida){
        Partida partida = null;
        for (Partida p : partidas) {
            if (p.getId().equals(idPartida))
            {
                partida = p;
            }
        }

        List<User> jugadores = new ArrayList<>(partida.getParticipantes().values());
        jugadores.sort(new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return Double.compare(u1.getPuntos(),u2.getPuntos());
            }
        });
        return jugadores;
    }

    public List<Partida> getMyPartidas(String idUser){
        return this.users.get(idUser).getMisPartidas();
    }

    /**
    public List<String> actividad(String idUser, String idPartida){
        Actividad actividad = new Actividad(idUser,idPartida);
        return
    }*/



    //////////////////////////////////////////////////////////////////////////////////////////////////

    public void updateUser(String id, String nombre, String apellidos, String nacimiento, String correo, String password){
        User u = users.get(id);
        u.setNombre(nombre);
        u.setApellidos(apellidos);
        u.setNacimiento(nacimiento);
        u.setCorreo(correo);
        u.setPassword(password);
    }

    public int getNumUser() {
        int numUser = this.users.size();
        logger.info("size " + numUser);
        return numUser;
    }

    public int getNumPartidas() {
        int numObject = this.partidas.size();
        logger.info("size " + numObject);
        return numObject;
    }

    public List<User> getUsers() {
        logger.info("users " + users);
        List<User> userList = new ArrayList<>(this.users.values());
        return userList;
    }

    public List<Partida> getPartidas() {
        logger.info("partidas " + partidas);
        return this.partidas;
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


}