package com.dfb.recommender.rest.dto;

import com.dfb.recommender.entities.Rating;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dante on 3/4/2018.
 */
@XmlRootElement(name="rating")
public class RatingDto implements BaseDto<Rating> {

    private Long id;
    private Long movieId;
    private Long userId;
    private double qualification;
    private MovieDto movie;
    private UserDto user;

    @Override
    public Rating toData() {
        return null;
    }

    @Override
    public void fromData(Rating data) {
        this.id = data.getId();
        this.movieId = data.getMovie().getId();
        this.userId = data.getUser().getId();
        UserDto userDto = new UserDto();
        userDto.fromData(data.getUser());
        this.user = userDto;
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

    public double getQualification() {
        return qualification;
    }

    public UserDto getUser() {
        return user;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getUserId() {
        return userId;
    }
}
