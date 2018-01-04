package com.iss.model;

/**
 * Created by kalyankonidena on 12/26/17.
 */

public class ISSPassTimes {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ISSPassTimes getRequest() {
        return request;
    }

    public void setRequest(ISSPassTimes request) {
        this.request = request;
    }

    private ISSPassTimes request;


    private String risetime;
    private String duration;

    public String getRisetime() {
        return risetime;
    }

    public void setRisetime(String risetime) {
        this.risetime = risetime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}
