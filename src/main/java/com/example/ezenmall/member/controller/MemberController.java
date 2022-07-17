package com.example.ezenmall.member.controller;
import com.example.ezenmall.member.model.dto.MemberJoinRequest;
import com.example.ezenmall.member.model.dto.MemberLoginRequest;
import com.example.ezenmall.member.model.dto.MemberUpdateRequest;
import com.example.ezenmall.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/members")
@Controller
public class MemberController {
    private final MemberService service;
    public MemberController(MemberService service) {
        this.service = service;
    }
    @PostMapping(value = "/login")
    public void login(MemberLoginRequest request) {
        boolean result = service.login(request);
    }
    @PostMapping(value = "/join")
    public void join(MemberJoinRequest memberJoinRequest) {
        boolean result = service.join(memberJoinRequest);
    }
    @PatchMapping(value = "")
    public void update(MemberUpdateRequest memberUpdateRequest) {
        boolean result = service.update(memberUpdateRequest);
    }
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        boolean result = service.delete(id);
    }
}
