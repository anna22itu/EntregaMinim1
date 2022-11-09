package edu.upc.dsa;

import edu.upc.dsa.models.MyObject;
import edu.upc.dsa.models.User;
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

        MyObject o1 = new MyObject("Espada", "Espada con poderes", 3.1);
        gj.addObject(o1);
        MyObject o2 = new MyObject("Anillo", "Anillo teletransportador", 2.7);
        gj.addObject(o2);
        MyObject o3 = new MyObject("Traje", "Traje invisible", 4.5);
        gj.addObject(o3);
        MyObject o4 = new MyObject("Gafas", "Gafas visión del futuro", 5.25);
        gj.addObject(o4);
        MyObject o5 = new MyObject("Pistola", "Pistola laser", 1.35);
        gj.addObject(o5);
        MyObject o6 = new MyObject("Capa", "Capa voladora", 5);
        gj.addObject(o6);

        gj.purchaseObject("Anillo", "11111");
        gj.purchaseObject("Pistola", "11111");
    }

    @After
    public void tearDown() {
        this.gj = null;
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
    public void ordenarUserAlfabet() {
        List<User> users = this.gj.ordenarUserAlfabet();

        Assert.assertEquals("David", users.get(0).getNombre());

        Assert.assertEquals("Juan", users.get(1).getNombre());

        Assert.assertEquals("Mario", users.get(2).getNombre());
    }

    @Test
    public void logIn() {
        Assert.assertFalse(gj.logIn("jlor@gmail.com", "megustsa"));

        Assert.assertTrue(gj.logIn("jlopezr@gmail.com", "megustadsa"));

        Assert.assertFalse(gj.logIn("drincon@gmail.com", "dsapracticarr"));

        Assert.assertTrue(gj.logIn("drincon@gmail.com", "dsapracticar"));
    }

    @Test
    public void addObject() {
        Assert.assertEquals(6, this.gj.getNumObject());
        MyObject o7 = new MyObject("Pocima", "Pocima con veneno", 5);
        gj.addObject(o7);
        Assert.assertEquals(7, this.gj.getNumObject());
    }

    @Test
    public void ordenarObjectsByPrice() {
        List<MyObject> objects = this.gj.ordenarObjectByPrice();

        Assert.assertEquals("Gafas", objects.get(0).getNombre());
        Assert.assertEquals(5.25, objects.get(0).getCoins(), 0);

        Assert.assertEquals("Capa", objects.get(1).getNombre());
        Assert.assertEquals(5, objects.get(1).getCoins(), 0);

        Assert.assertEquals("Traje", objects.get(2).getNombre());
        Assert.assertEquals(4.5, objects.get(2).getCoins(), 0);

        Assert.assertEquals("Espada", objects.get(3).getNombre());
        Assert.assertEquals(3.1, objects.get(3).getCoins(), 0);

        Assert.assertEquals("Anillo", objects.get(4).getNombre());
        Assert.assertEquals(2.7, objects.get(4).getCoins(), 0);

        Assert.assertEquals("Pistola", objects.get(5).getNombre());
        Assert.assertEquals(1.35, objects.get(5).getCoins(), 0);
    }


    @Test
    public void purchaseObject() {
        Assert.assertEquals(2, this.gj.getnumObjectUser("11111"));

        gj.purchaseObject("Traje", "11111");
        gj.purchaseObject("Capa", "11111");

        Assert.assertEquals(36.45, gj.getUser("11111").getSaldo(), 0.5); //precisio delta quan comparem doubles
        Assert.assertEquals(4, this.gj.getUser("11111").getNumberMisObjetos());

        Assert.assertEquals(4, this.gj.getnumObjectUser("11111"));
    }

    @Test
    public void listObjectByUser() {
        gj.purchaseObject("Traje", "11111");
        Assert.assertEquals(3, this.gj.getUser("11111").getNumberMisObjetos());

        Assert.assertEquals(gj.getObject("Anillo"), gj.listObjectByUser("11111").get(0));
        Assert.assertEquals(gj.getObject("Pistola"), gj.listObjectByUser("11111").get(1));
        Assert.assertEquals(gj.getObject("Traje"), gj.listObjectByUser("11111").get(2));
    }

    @Test
    public void updateUser() {
        gj.updateUser("22222", "David", "Rincon", "13/10/1995", "drincon@gmail.com", "jye-21-dneidsfw");

        Assert.assertEquals(gj.getUser ("22222").getNacimiento(), "13/10/1995");
        Assert.assertEquals(gj.getUser ("22222").getPassword(), "jye-21-dneidsfw");
    }

}