package com.villarruel.mangas.dto;

public class AuthenticationRequest {

    private String userName;
    private String password;

    public String getUsername() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
