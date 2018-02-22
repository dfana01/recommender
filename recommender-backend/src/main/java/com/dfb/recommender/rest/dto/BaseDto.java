package com.dfb.recommender.rest.dto;

import java.io.Serializable;

/**
 * Created by Dante on 2/22/2018.
 */
public interface BaseDto<T> extends Serializable {
    T toData();
    void fromData(T data);
}
