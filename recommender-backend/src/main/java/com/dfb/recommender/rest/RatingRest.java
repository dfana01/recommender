package com.dfb.recommender.rest;

import com.dfb.recommender.core.RatingDao;
import com.dfb.recommender.entities.Movie;
import com.dfb.recommender.entities.Rating;
import com.dfb.recommender.rest.dto.ExceptionDto;
import com.dfb.recommender.rest.dto.RatingDto;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dante on 2/22/2018.
 */
@Path("/rating")
@Stateless
public class RatingRest extends RatingDao {

    @PersistenceContext
    private EntityManager em;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(RatingDto ratingDto) {
        try {
            Rating rating = this.rate(ratingDto);
            ratingDto = new RatingDto();
            rating.getMovie().getLinks();
            rating.getUser().getCredential();
            ratingDto.fromData(rating);
            return Response.ok(ratingDto).build();
        } catch (EntityExistsException e){
            ExceptionDto exceptionDto = new ExceptionDto();
            exceptionDto.fromData(e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
