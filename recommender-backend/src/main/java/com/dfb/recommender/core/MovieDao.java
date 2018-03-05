package com.dfb.recommender.core;

import com.dfb.recommender.entities.Movie;

/**
 * Created by Dante on 2/21/2018.
 */

public abstract class MovieDao extends DaoJpa<Movie> {

    public MovieDao() {
        super(Movie.class);
    }



}
