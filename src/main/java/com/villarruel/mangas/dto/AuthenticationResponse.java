package com.villarruel.mangas.dto;

public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJtw(String jwt) {
        this.jwt = jwt;
    }

}
