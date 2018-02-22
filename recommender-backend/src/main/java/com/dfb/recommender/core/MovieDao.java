package com.dfb.recommender.core;

import com.dfb.recommender.entities.Movie;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Dante on 2/21/2018.
 */
@Stateless
public class MovieDao extends DaoJpa<Movie> {

    @PersistenceContext
    private EntityManager em;

    public MovieDao() {
        super(Movie.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return this.em;
    }

    @Override
    public List<Movie> findRange(int[] range) {
        List<Movie> movies = super.findRange(range);
        movies.forEach(movie -> movie.getLink());
        return movies;
    }
}
