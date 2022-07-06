package com.example.ezenmall.member.model.dto;

public class UpdateRequest {
    private Long id; //오토인크리먼트 써서 자동으로 추가되지만 받아와야함(createRequest와의 차이)
    private String password;
    private String name;
    private String email;
    private String phone;
    private String address;


    public Long getId() {
        return id;
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

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
}
