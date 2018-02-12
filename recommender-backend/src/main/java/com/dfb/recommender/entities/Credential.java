package com.dfb.recommender.entities;

import javax.persistence.*;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
public class Credential {

    private Long id;
    private User user;
    private String username;
    private String password;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="credential")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(nullable = true, length = 200)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(nullable = true, length = 1000)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
