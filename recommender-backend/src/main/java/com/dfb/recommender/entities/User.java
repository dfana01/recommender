package com.dfb.recommender.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private List<Recommendation> recommendations;
    private List<Rating> ratings;
    private List<Viewed> vieweds;
    private Credential credential;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(nullable = false, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(nullable = false, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(nullable = false, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user",cascade=CascadeType.PERSIST)
    public List<Recommendation> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<Recommendation> recommendations) {
        this.recommendations = recommendations;
    }

    @OneToMany(mappedBy = "user",cascade=CascadeType.PERSIST)
    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    @OneToMany(mappedBy = "user",cascade=CascadeType.PERSIST)
    public List<Viewed> getVieweds() {
        return vieweds;
    }

    public void setVieweds(List<Viewed> vieweds) {
        this.vieweds = vieweds;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user")
    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
