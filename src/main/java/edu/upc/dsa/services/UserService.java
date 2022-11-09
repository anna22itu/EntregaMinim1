package edu.upc.dsa.services;


import edu.upc.dsa.GestorJuego;
import edu.upc.dsa.GestorJuegoImpl;
import edu.upc.dsa.models.MyObject;
import edu.upc.dsa.models.User;
import edu.upc.dsa.models.UserLogIn;
import edu.upc.dsa.models.UserReg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/User", description = "Endpoint to User Service")
@Path("/User")
public class UserService {

    private GestorJuego gj;

    public UserService() {
        this.gj = GestorJuegoImpl.getInstance();
        if (gj.getNumUser() == 0) {
            this.gj.registerUser("11111", "Juan", "Lopez", "22/05/1990", "jlopezr@gmail.com", "megustadsa");
            this.gj.registerUser("22222", "David", "Rincon", "13/01/1994", "drincon@gmail.com", "dsapracticar");
            this.gj.registerUser("33333", "Mario", "Hernández", "06/12/1989", "mhernandez@gmail.com", "nosequeponer");
            this.gj.registerUser("44444", "Anna", "Iturralde", "13/01/2001", "annaiturralde@gmail.com", "minimo1");
        }
        if (gj.getNumObject() == 0) {
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
        }

        gj.purchaseObject("Anillo", "11111");
        gj.purchaseObject("Pistola", "11111");
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List of Users"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsers() {

        List<User> users = this.gj.getUsers();

        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {
        };
        return Response.status(201).entity(entity).build();
    }

    @GET
    @ApiOperation(value = "get all Objects", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = MyObject.class, responseContainer = "List"),
    })
    @Path("/MyObject")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObjects() {

        List<MyObject> objects = this.gj.getCatalogo();
        GenericEntity<List<MyObject>> entity = new GenericEntity<List<MyObject>>(objects) {
        };
        return Response.status(201).entity(entity).build();

    }

    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("id") String id) {
        User u = this.gj.getUser(id);
        if (u == null) return Response.status(404).build();
        else return Response.status(201).entity(u).build();
    }

    @GET
    @ApiOperation(value = "get an Object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = MyObject.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/MyObject/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObject(@PathParam("nombre") String nombre) {
        MyObject o = this.gj.getObject(nombre);
        if (o == null) return Response.status(404).build();
        else return Response.status(201).entity(o).build();
    }


    @DELETE
    @ApiOperation(value = "delete a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        User user = this.gj.getUser(id);
        if (user == null) return Response.status(404).build();
        else this.gj.deleteUser(id);
        return Response.status(201).build();
    }


    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/resgisterUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response resgisterUser(UserReg userReg) {
        if (userReg.getCorreoReg() == null || userReg.getPasswordReg() == null)
            return Response.status(500).entity(userReg).build();
        this.gj.registerUser(userReg.getIdReg(), userReg.getNombreReg(), userReg.getApellidosReg(), userReg.getNacimientoReg(), userReg.getCorreoReg(), userReg.getPasswordReg());
        return Response.status(201).entity(userReg).build();
    }


    @POST
    @ApiOperation(value = "logIn User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/logIn")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response logIn(UserLogIn userLogIn) {
        if (userLogIn.getCorreoLI() == null || userLogIn.getPasswordLI() == null)
            return Response.status(500).entity(userLogIn).build();
        if (this.gj.logIn(userLogIn.getCorreoLI(), userLogIn.getPasswordLI()))
            return Response.status(201).entity(userLogIn).build();
        else return Response.status(404).entity(userLogIn).build();
    }


    @GET
    @ApiOperation(value = "get a all User alphabetically arranged", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/sort/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ordenarUserAlfabet() {
        List<User> users = this.gj.ordenarUserAlfabet();
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(users) {
        };
        return Response.status(201).entity(entity).build();
    }


    @GET
    @ApiOperation(value = "get a all Objects of a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = MyObject.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}/MyObject/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listObjectByUser(@PathParam("id") String id) {
        List<MyObject> myObjects = this.gj.listObjectByUser(id);
        GenericEntity<List<MyObject>> entity = new GenericEntity<List<MyObject>>(myObjects) {
        };
        return Response.status(201).entity(entity).build();
    }


    @GET
    @ApiOperation(value = "purchase an Object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}/{nameObject}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response purchaseObject(@PathParam("nameObject") String nameObject, @PathParam("id") String id) {
        boolean resultado = this.gj.purchaseObject(nameObject, id);
        if (resultado) return Response.status(201).build();
        else return Response.status(404).entity(resultado).build();
    }


    @PUT
    @ApiOperation(value = "update a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserReg user) {
        this.gj.updateUser(user.getIdReg(),user.getNombreReg(),user.getApellidosReg(),user.getNacimientoReg(),user.getCorreoReg(),user.getPasswordReg());
        if (user.getIdReg() == null) return Response.status(404).build();
        else return Response.status(201).entity(user).build();
    }


}