package com.dfb.recommender.rest;

import com.dfb.recommender.core.RatingDao;
import com.dfb.recommender.entities.Movie;
import com.dfb.recommender.entities.Rating;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Dante on 2/22/2018.
 */
@Path("/rating")
public class RatingRest {

    public class NoMovieFound extends WebApplicationException {
        public NoMovieFound(String message) {
            super(Response.status(Response.Status.NOT_FOUND)
                    .entity(message).type(MediaType.TEXT_PLAIN).build());
        }
    }

    @Inject
    private RatingDao ratingDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response rate(Rating rating) {
        if(rating.getMovie() == null){
            throw new NoMovieFound("No movie found.");
        }
        ratingDao.create(rating);
        return Response.status(Response.Status.OK).build();
    }
}
