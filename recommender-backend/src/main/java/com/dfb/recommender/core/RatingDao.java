package com.dfb.recommender.core;

import com.dfb.recommender.entities.Credential;
import com.dfb.recommender.entities.Movie;
import com.dfb.recommender.entities.Rating;
import com.dfb.recommender.entities.User;
import com.dfb.recommender.rest.dto.ExceptionDto;
import com.dfb.recommender.rest.dto.RatingDto;

import javax.ejb.DuplicateKeyException;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 * Created by Dante on 2/22/2018.
 */
public abstract class RatingDao extends DaoJpa<Rating> {

    public RatingDao() {
        super(Rating.class);
    }

    public Rating rate(RatingDto ratingDto){
        User user = getEntityManager().find(User.class, ratingDto.getUserId());;
        Movie movie = getEntityManager().find(Movie.class, ratingDto.getMovieId());
        Rating rating = new Rating();
        rating.setMovie(movie);
        rating.setUser(user);
        rating.setQualification(ratingDto.getQualification());
        try {
            this.create(rating);
        } catch (EntityExistsException e){
            throw e;
        }
        return rating;
    }
}
