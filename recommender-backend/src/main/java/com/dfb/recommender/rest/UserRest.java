package com.dfb.recommender.rest;

import com.dfb.recommender.core.UserDao;
import com.dfb.recommender.entities.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by Dante on 2/22/2018.
 */
@Path("/user")
public class UserRest {

    @Inject
    private UserDao userDao;


    @GET
    @Produces({"application/json"})
    public List<User> list() {
        return userDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Response getUser(@PathParam("id") Long id) {
        User user = userDao.find(id);
        if (user != null) {
            return Response.ok(user).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    @Produces({"application/json"})
    public Response insertUser(User user){
        userDao.create(user);
        return Response.status(Response.Status.OK).build();
    }
}
