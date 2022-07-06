package com.example.ezenmall.member.model.dto;

public class JoinRequest {
    private String loginId;
    private String password;
    private String name;
    private String email;
    private String telephone;
    private String address;

    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }
}
