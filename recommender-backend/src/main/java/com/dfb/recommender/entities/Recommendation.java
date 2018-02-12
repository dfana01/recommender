package com.dfb.recommender.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
@XmlRootElement
public class Recommendation {

    public enum Type{
        SIMILAR_OBJECT("Objectos Similares"),
        COLLABORATIVE_FILTERING("Filtrado Colaborativo");

        private final String text;

        Type(final String text){ this.text = text; }

        @Override
        public String toString(){ return text; }
    }

    private Long id;
    private Movie movie;
    private User user;
    private Date date;
    private Type type;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie", referencedColumnName = "id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(nullable =  false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 100)
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
