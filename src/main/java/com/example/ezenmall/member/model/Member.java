package com.example.ezenmall.member.model;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "loginId")
    private String loginId;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "createDate")
    private LocalDateTime createDate;
    @Column(name = "updateDate")
    private LocalDateTime updateDate;

    public Member() {

    }


    public Long getId() {
        return id;
    }

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

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public Member(String loginId, String password, String name, String email, String phone, String address) {
        this.loginId = loginId;
        this.password = password;
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void updateMember(String name, String email, String phone, String address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

}
