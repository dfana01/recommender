package com.dfb.recommender.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
@Table(uniqueConstraints={
        @UniqueConstraint(columnNames = {"email"})
})
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private List<Recommendation> recommendations;
    private List<Rating> ratings;
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
    @Column(nullable = true, length = 100)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(nullable = true, length = 100)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(nullable = true, length = 100)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(nullable = true, length = 100)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @OneToMany(mappedBy = "user",cascade=CascadeType.PERSIST)
    @OrderBy("date desc")
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


    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="credential", referencedColumnName = "id")
    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }
}
