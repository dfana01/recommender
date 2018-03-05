package com.dfb.recommender.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dante on 3/5/2018.
 */
@XmlRootElement(name = "error")
public class ExceptionDto implements BaseDto<Exception> {
    private String error;
    private String message;

    @Override
    public Exception toData() {
        return null;
    }

    @Override
    public void fromData(Exception data) {
        this.error = data.getClass().getSimpleName();
        this.message = data.getMessage();
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
