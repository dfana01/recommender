package com.dfb.recommender.rest.dto;

import com.dfb.recommender.entities.Link;
import com.dfb.recommender.entities.Movie;
import com.dfb.recommender.entities.Rating;
import com.dfb.recommender.entities.Tag;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Dante on 2/22/2018.
 */
@XmlRootElement(name = "movie")
public class MovieDto implements BaseDto<Movie> {

    private Long id;
    private String title;
    private String[] genres;
    private Link link;
    private List<Tag> tags;
    private double rating;

    @Override
    public Movie toData() {
        return null;
    }

    @Override
    public void fromData(Movie data) {
        this.id = data.getId();
        this.title = data.getTitle();
        this.genres = data.getGenres().split("\\|");
        this.link = data.getLink();
        if(data.getRatings().size() == 0){
            this.rating = 0.;
        }else{
            double sum = 0;
            List<Rating> ratings = data.getRatings();
            for (Rating rating: ratings){
                sum += rating.getQualification();
            }
            this.rating = sum / ratings.size();
        }
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String[] getGenres() {
        return genres;
    }

    public Link getLink() {
        return link;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public double getRating() {
        return rating;
    }
}
