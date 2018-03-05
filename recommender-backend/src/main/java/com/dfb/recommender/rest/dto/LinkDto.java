package com.dfb.recommender.rest.dto;

import com.dfb.recommender.entities.Link;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dante on 3/4/2018.
 */
@XmlRootElement(name = "link")
public class LinkDto implements BaseDto<Link> {

    private Long id;
    private int imdbid;
    private int tmdbid;

    @Override
    public Link toData() {
        return null;
    }

    @Override
    public void fromData(Link data) {
        this.id = data.getId();
        this.imdbid = data.getImdbid();
        this.tmdbid = data.getTmdbid();
    }

    public Long getId() {
        return id;
    }

    public int getImdbid() {
        return imdbid;
    }

    public int getTmdbid() {
        return tmdbid;
    }
}
