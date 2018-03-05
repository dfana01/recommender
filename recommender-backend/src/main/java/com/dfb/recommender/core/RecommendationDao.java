package com.dfb.recommender.core;

import com.dfb.recommender.entities.Recommendation;
import com.dfb.recommender.entities.User;

import java.util.List;

/**
 * Created by Dante on 3/4/2018.
 */
public abstract class RecommendationDao extends DaoJpa<Recommendation> {

    public RecommendationDao() { super(Recommendation.class); }

    public List<Recommendation> getRecommendation(long userId){
        User user = this.getUser(userId);
        return user.getRecommendations();
    }

    private User getUser(long id){
        return getEntityManager().find(User.class, id);
    }
}
