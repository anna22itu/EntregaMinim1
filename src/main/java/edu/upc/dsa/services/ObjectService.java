package edu.upc.dsa.services;

import edu.upc.dsa.GestorJuego;
import edu.upc.dsa.GestorJuegoImpl;
import edu.upc.dsa.models.Object;
import io.swagger.annotations.Api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Api(value = "/text", description = "Endpoint to Text Service")
@Path("text")
public class ObjectService {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */

    private GestorJuego gj;

    public ObjectService() {
        this.gj = GestorJuegoImpl.getInstance();
        if (gj.getNumUser()==0) {
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
        }
    }
    @Path("basic")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    @Path("users/{username}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser(@PathParam("username") String userName) {
        return "Hello " + userName;
    }

    @Path("exception")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String throwIt() throws Exception {
        throw new Exception("My Exception");
    }

}
