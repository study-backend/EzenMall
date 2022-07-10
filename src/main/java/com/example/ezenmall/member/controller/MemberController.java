package com.example.ezenmall.member.controller;
import com.example.ezenmall.member.model.dto.MemberJoinRequest;
import com.example.ezenmall.member.model.dto.MemberLoginRequest;
import com.example.ezenmall.member.model.dto.MemberUpdateRequest;
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
    public void login(MemberLoginRequest request) {
        boolean result = service.login(request);
    }
    @PostMapping
    public void join(MemberJoinRequest memberJoinRequest) {
        boolean result = service.join(memberJoinRequest);
    }
    @PatchMapping
    public void update(MemberUpdateRequest memberUpdateRequest) {
        boolean result = service.update(memberUpdateRequest);
    }
    @DeleteMapping("/api/members/{id}")
    public void delete(@PathVariable Long id) {
        boolean result = service.delete(id);
    }
}
