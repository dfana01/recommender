package com.dfb.recommender.core;

import com.dfb.recommender.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Dante on 2/22/2018.
 */
@Stateless
public class UserDao extends DaoJpa<User>{

    @PersistenceContext
    private EntityManager em;

    public UserDao() {
        super(User.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
