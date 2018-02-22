package com.dfb.recommender.core;

import com.dfb.recommender.entities.Rating;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dante on 2/22/2018.
 */
@Stateless
public class RatingDao extends DaoJpa<Rating> {

    @PersistenceContext
    private EntityManager em;

    public RatingDao() {
        super(Rating.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
