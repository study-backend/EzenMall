package com.example.ezenmall.member.model;

import com.example.ezenmall.BaseTimeEntity;
import com.example.ezenmall.order.model.Orders;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Members")
public class Member extends BaseTimeEntity {
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

    @OneToMany(mappedBy = "member") // 상대편에서 사용되는 본인의 이름하고 맵핑하는 것
    private List<Orders> orders;

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
