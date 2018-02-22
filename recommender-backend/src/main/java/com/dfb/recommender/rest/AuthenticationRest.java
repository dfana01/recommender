package com.dfb.recommender.rest;

import com.dfb.recommender.core.DaoJpa;
import com.dfb.recommender.entities.Credential;
import com.dfb.recommender.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dante on 2/22/2018.
 */
@Path("/authentication")
@Stateless
public class AuthenticationRest extends DaoJpa<User> {

    @PersistenceContext
    private EntityManager em;

    public AuthenticationRest() {
        super(User.class);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(Credential credential) {
        try {
            System.out.println(credential);
            return Response.ok(this.login(credential)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Credential login(Credential credential){
        TypedQuery<Credential> query =
                em.createNamedQuery("Credential.login", Credential.class);
        query.setParameter("username",credential.getUser());
        query.setParameter("password",credential.getPassword());
        Credential credentialFromDb = query.getSingleResult();
        System.out.println(credentialFromDb);
        return credentialFromDb;
    }
}
