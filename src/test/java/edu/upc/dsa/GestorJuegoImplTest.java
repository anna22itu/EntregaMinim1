package edu.upc.dsa;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Data.*;
import edu.upc.dsa.models.Partida;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class GestorJuegoImplTest {

    GestorJuego gj;


    @Before
    public void setUp() {
        gj = new GestorJuegoImpl();
        gj.registerUser("11111", "Juan", "lopez", "22/05/1990", "jlopezr@gmail.com", "megustadsa");
        gj.registerUser("22222", "David", "Rincon", "13/01/1994", "drincon@gmail.com", "dsapracticar");
        gj.registerUser("33333", "Mario", "Hernández", "06/12/1989", "mhernandez@gmail.com", "nosequeponer");

        gj.crearPartida("11", "Partida 1", 8);
        gj.crearPartida("22", "Partida 2", 6);
        gj.crearPartida("33", "Partida 3", 4);
        gj.crearPartida("44", "Partida 4", 10);
        gj.crearPartida("55", "Partida 5", 2);

        gj.iniciarPartida("22", "11111");
        gj.iniciarPartida("22", "22222");
    }


    @After
    public void tearDown() {
        this.gj = null;
    }

    @Test
    public void CrearPartida() {
        Assert.assertEquals(5, this.gj.getNumPartidas());

        gj.crearPartida("66", "Partida 6", 7);

        Assert.assertEquals(6, this.gj.getNumPartidas());
    }


    @Test
    public void registerUser() {
        Assert.assertEquals(3, this.gj.getNumUser());

        gj.registerUser("77777", "Emma", "Garcia", "18/11/1990", "emmagarcia@gmail.com", "contraseña");

        Assert.assertEquals(4, this.gj.getNumUser());
    }


    @Test
    public void deleteUser() {
        gj.deleteUser("22222");
        Assert.assertEquals(2, this.gj.getNumUser());
    }


    @Test
    public void iniciarPartida() {
        Assert.assertEquals("22", this.gj.getUser("11111").getMyCurrentPartida().getId());
        Assert.assertEquals("22", this.gj.getUser("22222").getMyCurrentPartida().getId());

        Assert.assertEquals(0, this.gj.getUser("11111").getcurrentNivel());
        Assert.assertEquals(0, this.gj.getUser("22222").getcurrentNivel());
    }

    @Test
    public void nivelActual() {
        gj.pasarNivel("11111",70,"14:16:09");
        gj.pasarNivel("11111",50,"17:16:09");
        gj.pasarNivel("22222",80,"14:16:09");

        Assert.assertEquals(2, this.gj.nivelUser("11111"));
        Assert.assertEquals(1, this.gj.nivelUser("22222"));
    }

    @Test
    public void puntacionActual() {
        gj.pasarNivel("11111",70,"14:16:09");
        gj.pasarNivel("11111",50,"17:16:09");
        gj.pasarNivel("22222",80,"14:16:09");

        Assert.assertEquals(170, this.gj.puntosDeUser("11111"),1);
        Assert.assertEquals(130, this.gj.puntosDeUser("22222"),1);
    }

    @Test
    public void pasarNivel() {
        gj.finalizarPartida("11111");
        Assert.assertNull(this.gj.getUser("11111").getMyCurrentPartida());
    }

    @Test
    public void finalizarPartida() {
        gj.pasarNivel("11111",70,"14:16:09");
        gj.pasarNivel("11111",50,"17:16:09");

        Assert.assertEquals(2,this.gj.nivelUser("11111"));
    }

    @Test
    public void UserPartida() {
        List<User> users = this.gj.getUsersOfPartida("22");

        Assert.assertEquals(2,users.size());

        Assert.assertEquals("11111", users.get(0).getId());
        Assert.assertEquals("22222", users.get(1).getId());
    }


    @Test
    public void getMyPartidas() {
        gj.finalizarPartida("11111");
        gj.iniciarPartida("55", "11111");

        List<Partida> mispartidas = gj.getMyPartidas("11111");

        Assert.assertEquals(2,mispartidas.size());

        Assert.assertEquals("22",mispartidas.get(0).getId());
        Assert.assertEquals("55",mispartidas.get(1).getId());
    }


    @Test
    public void actividad() {
        gj.iniciarPartida("33","33333");

        gj.pasarNivel("33333",70,"15:16:09");
        gj.pasarNivel("33333",50,"20:16:09");
        gj.pasarNivel("33333",80,"10:16:09");

        gj.finalizarPartida("33333");

        List<DatosActivity> myActivity = gj.actividad("33333","33");

        Assert.assertEquals(3,myActivity.size());

        Assert.assertEquals(70,myActivity.get(0).getPuntosAct(),0);
        Assert.assertEquals(50,myActivity.get(1).getPuntosAct(),0);
        Assert.assertEquals(80,myActivity.get(2).getPuntosAct(),0);
    }
}