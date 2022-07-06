package com.example.ezenmall.member.controller;


import com.example.ezenmall.member.model.dto.JoinRequest;
import com.example.ezenmall.member.model.dto.LoginRequest;
import com.example.ezenmall.member.model.dto.UpdateRequest;
import com.example.ezenmall.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {


    private MemberService service;

    public MemberController(MemberService service) {
        this.service = service;
    }

    @PostMapping
    public void login(LoginRequest request) {
        boolean result = service.login(request);

//        if(cnt == 1) { //아이디 있고 비번 일치
//            session.setAttribute("memberId", id);
//            out.print("alert('로그인 되었습니다.');");
//            out.print("location='../shopping/shopAll.jsp';");
//        }else if(cnt == 0) {   //아이디 있고 비번 불일치
//            out.print("alert('비밀번호가 일치하지 않습니다.');history.back();");
//
//        }else if(cnt == -1) { //아이디 없을 때
//            out.print("alert('아이디가 존재하지 않습니다.');history.back();");
//        }

    }

    public void join(JoinRequest joinRequest) {
        boolean result = service.join(joinRequest);

    }

    @PatchMapping
    public void update(UpdateRequest updateRequest) {
        boolean result = service.update(updateRequest);
    }

    @DeleteMapping("/api/members/{id}")
    public void delete(@PathVariable Long id) {
        boolean result = service.delete(id);
    }

}
