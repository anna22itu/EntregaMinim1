package edu.upc.dsa.services;


import edu.upc.dsa.GestorJuego;
import edu.upc.dsa.GestorJuegoImpl;
import edu.upc.dsa.models.*;
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
        if (gj.getNumPartidas() == 0) {
            gj.crearPartida("11", "Partida 1", 8);
            gj.crearPartida("22", "Partida 2", 6);
            gj.crearPartida("33", "Partida 3", 4);
            gj.crearPartida("44", "Partida 4", 10);
            gj.crearPartida("55", "Partida 5", 2);
        }
        gj.iniciarPartida("22", "11111");
        gj.iniciarPartida("22", "22222");

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
    @ApiOperation(value = "get all Partidas", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class, responseContainer = "List"),
    })
    @Path("/Partidas")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartidas() {

        List<Partida> partidas = this.gj.getPartidas();
        GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(partidas) {
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
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nivelActual(@PathParam("idUser") String idUser) {
        int level = this.gj.nivelUser(idUser);
        if (level == 0) return Response.status(404).build();
        else return Response.status(201).entity(level).build();
    }


    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response puntuacionActual(@PathParam("idUser") String idUser) {
        double level = this.gj.puntosDeUser(idUser);
        if (level == 0) return Response.status(404).build();
        else return Response.status(201).entity(level).build();
    }


    /**
    @GET
    @ApiOperation(value = "get an Object", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/MyObject/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObject(@PathParam("nombre") String nombre) {
        Partida o = this.gj.getObject(nombre);
        if (o == null) return Response.status(404).build();
        else return Response.status(201).entity(o).build();
    }*/


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
    @ApiOperation(value = "create a new Partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/{Partida}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearNuevaPartida(@PathParam("Partida")Partida partida) {
        this.gj.crearPartida(partida.getId(), partida.getDescripcion(), partida.getNivel());
        return Response.status(201).entity(partida).build();
    }


    @POST
    @ApiOperation(value = "create a new Partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/inicioPArtida")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response iniciarNuevaPartida(Credentials credentials) {
        this.gj.iniciarPartida(credentials.getidPartida(), credentials.getidUser());
        return Response.status(201).entity(credentials).build();
    }

    @POST
    @ApiOperation(value = "finalizarPartida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class),
            @ApiResponse(code = 500, message = "Validation Error")
    })
    @Path("/finalPartida/{idUser}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response finalizarPartida(@PathParam("idUser")String idUser) {
        boolean end = this.gj.finalizarPartida(idUser);
        if (end) return Response.status(201).entity(idUser).build();
        else
    }

    @GET
    @ApiOperation(value = "get all Partidas of a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class, responseContainer = "List"),
    })
    @Path("/User/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPartidasUser(@PathParam("idUser")String idUser) {

        List<Partida> partidas = this.gj.getMyPartidas(idUser);
        GenericEntity<List<Partida>> entity = new GenericEntity<List<Partida>>(partidas) {
        };
        return Response.status(201).entity(entity).build();
    }


    @GET
    @ApiOperation(value = "get all users of a Partida", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Partida.class, responseContainer = "List"),
    })
    @Path("/Partida/{idUser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersOfPartida(@PathParam("idUser")String idUser) {

        List<User> user = this.gj.getUsersOfPartida(idUser);
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(user) {
        };
        return Response.status(201).entity(entity).build();
    }




    @PUT
    @ApiOperation(value = "update a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response pasarNivel(DatosPasarNivel datosPasarNivel) {
        this.gj.pasarNivel(datosPasarNivel.getIdUser(), datosPasarNivel.getPuntos(), datosPasarNivel.getFecha());
        if (datosPasarNivel.getFecha() == null || datosPasarNivel.getIdUser() == null) return Response.status(404).build();
        else return Response.status(201).entity(datosPasarNivel).build();
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