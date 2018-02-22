package com.dfb.recommender.core;

import com.dfb.recommender.entities.Movie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * Created by Dante on 2/21/2018.
 */
public class MovieRepository implements BaseRepository<Movie> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Movie> list() {
        em.
        return ;
    }

    @Override
    public Optional<Movie> get() {
        return null;
    }

}
