package com.dfb.recommender.rest.dto;

import com.dfb.recommender.entities.Recommendation;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Dante on 3/4/2018.
 */
@XmlRootElement(name = "recommendation")
public class RecommendationDto implements BaseDto<Recommendation>{

    private Long id;
    private MovieDto movie;
    private Date date;
    private Recommendation.Type type;

    @Override
    public Recommendation toData() {
        return null;
    }

    @Override
    public void fromData(Recommendation data) {
        this.id = data.getId();
        this.date = data.getDate();
        this.type = data.getType();
        MovieDto movieDto = new MovieDto();
        movieDto.fromData(data.getMovie());
        this.movie = movieDto;
    }

    public Long getId() {
        return id;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public Date getDate() {
        return date;
    }

    public Recommendation.Type getType() {
        return type;
    }
}
