package com.dfb.recommender.entities;

import javax.persistence.*;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"movie", "user"})
})
public class Rating {

    private Long id;
    private Movie movie;
    private double qualification;
    private User user;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie", referencedColumnName = "id")
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Basic
    @Column(nullable = false, precision = 1)
    public double getQualification() {
        return qualification;
    }


    public void setQualification(double qualification) {
        this.qualification = qualification;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
