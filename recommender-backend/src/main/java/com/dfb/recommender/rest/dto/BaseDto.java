package com.dfb.recommender.rest;

/**
 * Created by Dante on 2/22/2018.
 */
public interface Dto<T> {
    T toData();
    void fromData(T data);
}
