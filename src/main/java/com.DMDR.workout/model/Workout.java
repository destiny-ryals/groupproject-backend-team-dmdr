package com.DMDR.workout.model;

import java.util.UUID;

public class Workout {

    private final UUID id;
    private String title;
    private String imgUrl;
    private String intensity;
    private String time;
    private String bodyTarget;

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getIntensity() {
        return intensity;
    }

    public String getTime() {
        return time;
    }

    public String getBodyTarget() {
        return bodyTarget;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setBodyTarget(String bodyTarget) {
        this.bodyTarget = bodyTarget;
    }

    public Workout(UUID id, String title, String imgUrl, String intensity, String time, String bodyTarget) {
        this.id = id;
        this.title = title;
        this.imgUrl = imgUrl;
        this.intensity = intensity;
        this.time = time;
        this.bodyTarget = bodyTarget;
    }


}

