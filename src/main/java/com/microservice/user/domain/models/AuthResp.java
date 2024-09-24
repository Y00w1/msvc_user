package com.microservice.user.domain.models;

public class AuthResp {
    private User user;
    private String token;

    public AuthResp(User user, String token) {
        this.user = user;
        this.token = token;
    }

    public AuthResp() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
