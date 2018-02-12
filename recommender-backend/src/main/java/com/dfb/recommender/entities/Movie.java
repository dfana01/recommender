package com.dfb.recommender.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dante on 2/11/2018.
 */
@Entity
public class Movie {

    private Long id;
    private String title;
    private Link link;
    private List<Tag> tags;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(nullable = false, length = 1000)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="movie")
    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    @OneToMany(mappedBy = "movie",cascade=CascadeType.PERSIST)
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
