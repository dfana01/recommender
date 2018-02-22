package com.dfb.recommender.rest;


import com.dfb.recommender.core.MovieDao;
import com.dfb.recommender.entities.Movie;
import com.dfb.recommender.rest.dto.MovieDto;

import javax.inject.Inject;
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
public class MovieRest {

    @Inject
    private MovieDao movieDao;

    @GET
    @Path("/{from}/{to}")
    @Produces({"application/json"})
    public List<MovieDto> list( @PathParam("from") int from, @PathParam("to") int to) {
        final List<MovieDto> movies = new ArrayList<>();
        int[] range = {from,to};
        movieDao.findRange(range)
            .forEach(movie -> {
                MovieDto movieDto = new MovieDto();
                movieDto.fromData(movie);
                movies.add(movieDto);
            });
        return movies;
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public Response getMovie(@PathParam("id") Long id) {
        Movie movie = movieDao.find(id);
        MovieDto movieDto = new MovieDto();
        movieDto.fromData(movie);
        if (movie != null) {
            return Response.ok(movieDto).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
