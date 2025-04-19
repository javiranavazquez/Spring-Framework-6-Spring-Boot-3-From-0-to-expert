package com.tutorial.tutorial_spring_boot.models.dto;

import com.tutorial.tutorial_spring_boot.models.User;

public class userDTO {

    private String title;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
