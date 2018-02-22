package com.dfb.recommender.rest;

import com.dfb.recommender.core.CredentialDao;
import com.dfb.recommender.core.UserDao;
import com.dfb.recommender.entities.Credential;
import com.dfb.recommender.entities.Rating;
import com.dfb.recommender.entities.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dante on 2/22/2018.
 */
@Path("/authentication")
public class AuthenticationRest {

    @Inject
    private CredentialDao credentialDao;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(Credential credential) {
        try {
            authenticate(credential);
            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    private void authenticate(Credential credential) throws Exception {

    }
}
