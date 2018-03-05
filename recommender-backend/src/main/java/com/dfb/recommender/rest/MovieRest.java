package com.dfb.recommender.rest;


import com.dfb.recommender.core.MovieDao;
import com.dfb.recommender.entities.Movie;
import com.dfb.recommender.entities.User;
import com.dfb.recommender.rest.dto.MovieDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dante on 2/21/2018.
 */
@Path("/movie")
@Stateless
public class MovieRest extends MovieDao {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/{from}/{to}")
    @Produces({"application/json"})
    public List<MovieDto> list( @PathParam("from") int from, @PathParam("to") int to) {
        final List<MovieDto> movies = new ArrayList<>();
        int[] range = {from,to};
        this.findRange(range)
            .forEach(movie -> {
                MovieDto movieDto = new MovieDto();
                movie.getLinks().forEach(link -> link.getId());
                movieDto.fromData(movie);
                movies.add(movieDto);
            });
        return movies;
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Response getMovie(@PathParam("id") Long id) {
        Movie movie = this.find(id);
        MovieDto movieDto = new MovieDto();
        movieDto.fromData(movie);
        if (movie != null) {
            return Response.ok(movieDto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }
}
