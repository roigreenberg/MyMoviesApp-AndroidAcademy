package com.academy.fundamentals.models;

import com.academy.fundamentals.R;

public class Movie {
    private String title;
    private String overviews;
    private int image_id;

    public Movie(String title, String overviews, int image_id) {
        this.title = title;
        this.overviews = overviews;
        this.image_id = image_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverviews() {
        return overviews;
    }

    public void setOverviews(String overviews) {
        this.overviews = overviews;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }
}
