package com.dfb.recommender.rest;

import com.dfb.recommender.core.UserDao;
import com.dfb.recommender.entities.Credential;
import com.dfb.recommender.entities.User;
import com.dfb.recommender.rest.dto.UserDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dante on 2/22/2018.
 */
@Path("/authentication")
@Stateless
public class AuthenticationRest extends UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(Credential credential) {
        try {
            UserDto userDto = new UserDto();
            credential = this.login(credential);
            userDto.fromData(credential.getUser());
            return Response.ok(userDto).build();
        } catch (Exception e) {
            System.out.println(e.toString());
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(UserDto userDto) {
        try {
            userDto.fromData(this.register(userDto));
            return Response.ok(userDto).build();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
