package com.dfb.recommender.core;

import com.dfb.recommender.entities.Credential;
import com.dfb.recommender.entities.User;
import com.dfb.recommender.rest.dto.UserDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Created by Dante on 2/22/2018.
 */
public abstract class UserDao extends DaoJpa<User>{
    public UserDao() {
        super(User.class);
    }

    public Credential login(Credential credential){
        TypedQuery<Credential> query =
                this.getEntityManager().createNamedQuery("Credential.login", Credential.class);
        query.setParameter("username",credential.getUsername());
        query.setParameter("password",credential.getPassword());
        return query.getSingleResult();
    }

    public User register(UserDto userDto){
        User user = userDto.toData();
        Credential credential = user.getCredential();
        credential.setUser(user);
        this.getEntityManager().persist(credential);
        return credential.getUser();
    }
}
