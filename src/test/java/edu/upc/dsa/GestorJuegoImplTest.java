package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.upc.dsa.models.User;
import edu.upc.dsa.models.Object;

import java.util.List;

public class GestorJuegoImplTest {

    GestorJuego gj;


    @Before
    public void setUp() {
        gj = new GestorJuegoImpl();
        gj.registerUser("11111" ,"Juan", "lopez", "22/05/1990", "jlopezr@gmail.com","megustadsa");
        gj.registerUser("22222","David",  "Rincon", "13/01/1994","drincon@gmail.com","dsapracticar");
        gj.registerUser("33333","Mario",  "Hernández", "06/12/1989","mhernandez@gmail.com","nosequeponer");

        Object o1 = new Object("Espada", "Espada con poderes", 3.1);
        gj.addObject(o1);
        Object o2 =  new Object("Anillo", "Anillo teletransportador", 2.7);
        gj.addObject(o2);
        Object o3 = new Object("Traje", "Traje invisible", 4.5);
        gj.addObject(o3);
        Object o4 = new Object("Gafas", "Gafas visión del futuro", 5.25);
        gj.addObject(o4);
        Object o5 = new Object("Pistola", "Pistola laser", 1.35);
        gj.addObject(o5);
        Object o6 = new Object("Capa", "Capa voladora", 5);
        gj.addObject(o6);

        gj.purchaseObject(gj.getObject("Anillo"),"11111");
        gj.purchaseObject(gj.getObject("Pistola"),"11111");
    }

    @After
    public void tearDown() {
        this.gj = null;
    }

    @Test
    public void registerUser() {
        Assert.assertEquals(3,this.gj.getNumUser());
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
        Assert.assertFalse(gj.logIn("jlor@gmail.com","megustsa"));

        Assert.assertTrue(gj.logIn("jlopezr@gmail.com","megustadsa"));

        Assert.assertFalse(gj.logIn("drincon@gmail.com","dsapracticarr"));

        Assert.assertTrue(gj.logIn("drincon@gmail.com","dsapracticar"));
    }

    @Test
    public void addObject() {
        Assert.assertEquals(6, this.gj.getNumObject());
        Object o7 = new Object("Pocima", "Capa voladora", 5);
        gj.addObject(o7);
        Assert.assertEquals(7, this.gj.getNumObject());
    }

    @Test
    public void ordenarObjectsByPrice() {
        List<Object> objects = this.gj.ordenarObjectByPrice();

        Assert.assertEquals("Gafas", objects.get(0).getNombre());
        Assert.assertEquals(5.25, objects.get(0).getCoins(),0);

        Assert.assertEquals("Capa", objects.get(1).getNombre());
        Assert.assertEquals(5, objects.get(1).getCoins(), 0);

        Assert.assertEquals("Traje", objects.get(2).getNombre());
        Assert.assertEquals(4.5, objects.get(2).getCoins(), 0);

        Assert.assertEquals("Espada", objects.get(3).getNombre());
        Assert.assertEquals(3.1, objects.get(3).getCoins(), 0);

        Assert.assertEquals("Anillo", objects.get(4).getNombre());
        Assert.assertEquals(2.7, objects.get(4).getCoins(),0);

        Assert.assertEquals("Pistola", objects.get(5).getNombre());
        Assert.assertEquals(1.35, objects.get(5).getCoins(),0);
    }



    @Test
    public void purchaseObject() {
        gj.purchaseObject(gj.getObject("Traje"),"11111");
        gj.purchaseObject(gj.getObject("Capa"),"11111");

        Assert.assertEquals(36.45,gj.getUser("11111").getSaldo(),0.5); //precisio delta
        Assert.assertEquals(4,this.gj.getUser("11111").getNumberMisObjetos());

    }

    @Test
    public void listObjectByUser() {
        gj.purchaseObject(gj.getObject("Traje"),"11111");
        Assert.assertEquals(3,this.gj.getUser("11111").getNumberMisObjetos());

        Assert.assertEquals(gj.getObject("Anillo"),gj.listObjectByUser("11111").get(0));
        Assert.assertEquals(gj.getObject("Pistola"),gj.listObjectByUser("11111").get(1));
        Assert.assertEquals(gj.getObject("Traje"),gj.listObjectByUser("11111").get(2));
    }

}