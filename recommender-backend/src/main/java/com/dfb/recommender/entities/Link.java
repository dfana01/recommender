package com.dfb.recommender.entities;

import javax.persistence.*;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
public class Link {

    private Long id;
    private int imdbid;
    private int tmdbid;
    private Movie movie;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = true)
    public int getImdbid() {
        return imdbid;
    }

    public void setImdbid(int imdbid) {
        this.imdbid = imdbid;
    }

    @Basic
    @Column(nullable = true)
    public int getTmdbid() {
        return tmdbid;
    }

    public void setTmdbid(int tmdbid) {
        this.tmdbid = tmdbid;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="movie")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
