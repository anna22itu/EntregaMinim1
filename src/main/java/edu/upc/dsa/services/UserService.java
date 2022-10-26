package edu.upc.dsa.services;


import edu.upc.dsa.GestorJuego;
import edu.upc.dsa.GestorJuegoImpl;
import edu.upc.dsa.models.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;

@Api(value = "/tracks", description = "Endpoint to Track Service")
@Path("/tracks")
public class UserService {

    private GestorJuego gj;

    public UserService() {
        this.gj = GestorJuegoImpl.getInstance();
        if (gj.getNumUser()==0) {
            this.gj.registerUser("11111" ,"Juan", "lopez", "22/05/1990", "jlopezr@gmail.com","megustadsa");
            this.gj.registerUser("22222","David",  "Rincon", "13/01/1994","drincon@gmail.com","dsapracticar");
            this.gj.registerUser("33333","Mario",  "Hernández", "06/12/1989","mhernandez@gmail.com","nosequeponer");
        }
    }

    @GET
    @ApiOperation(value = "get all Users", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        HashMap<String,User> users = this.gj.getUsers();

        GenericEntity<HashMap<String,User>> entity = new GenericEntity<HashMap<String,User>>(users) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = User.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        User t = this.gj.getUser(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        User t = this.gj.getUser(id);
        if (t == null) return Response.status(404).build();
        else this.gj.deleteUser(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(User user) {

        User t = this.gj.updateUser(user);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response= User.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(User user) {

        if (user.getCorreo()==null || user.getPassword()==null)  return Response.status(500).entity(user).build();
        this.gj.registerUser(user);
        return Response.status(201).entity(user).build();
    }

}