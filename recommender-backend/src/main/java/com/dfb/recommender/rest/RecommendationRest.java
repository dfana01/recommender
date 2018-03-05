package com.dfb.recommender.rest;

import com.dfb.recommender.core.RecommendationDao;
import com.dfb.recommender.rest.dto.RecommendationDto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dante on 3/4/2018.
 */
@Path("/recommendation")
@Stateless
public class RecommendationRest extends RecommendationDao{

    @PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @GET
    @Path("/{id}")
    @Produces({"application/json"})
    public List<RecommendationDto> recommendation( @PathParam("id") long userId){
        final List<RecommendationDto> recommendations = new ArrayList<>();
        this.getRecommendation(userId).forEach(recommendation -> {
            RecommendationDto recommendationDto = new RecommendationDto();
            recommendationDto.fromData(recommendation);
            recommendations.add(recommendationDto);
        });
        return recommendations;
    }
}
